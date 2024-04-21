package changeSeat.Service;

import changeSeat.Error.Exception.InvalidInputException;
import changeSeat.Mapper.SiteUserMapper;
import changeSeat.Model.SiteUser.SiteUserDetail;
import changeSeat.Model.SiteUser.SiteUserRegister;
import changeSeat.Model.SiteUser.SiteUserUpdate;
import changeSeat.Request.SiteUser.SiteUserRegisterRequest;
import changeSeat.Request.SiteUser.SiteUserUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

import static java.util.Objects.isNull;

@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class SiteUserService {

    private final SiteUserMapper siteUserMapper;

    // 一覧取得
    public List<SiteUserDetail> getSiteUserList() {
        return siteUserMapper.getSiteUserList();
    }

    // 登録
    public void registerSiteUser(SiteUserRegisterRequest request, LocalDateTime now) {
        try {
            // 複合化してパスワードチェック
            if (checkDuplicateCertification(request.getLoginId(), request.getPassword())) {
                throw new InvalidInputException("入力されたログインIDとパスワードはすでに利用されています。");
            }
            siteUserMapper.insert(
                    SiteUserRegister.builder().
                            loginId(request.getLoginId())
                            .userName(request.getUserName())
                            .authority(request.getAuthority())
                            .password(request.getPassword())
                            .createdBy(0) // TODO ログインユーザID
                            .createdDt(now)
                            .updatedBy(0)
                            .updatedDt(now)
                            .build());
        } catch (DuplicateKeyException e) {
            throw new DuplicateKeyException("データの登録に失敗しました。再度お試しください。", e.getCause());
        }
    }

    // ユーザー詳細取得
    public SiteUserDetail getSiteUserDetail(int id) {
        var siteUserDetail = siteUserMapper.getSiteUserDetail(id);
        if (isNull(siteUserDetail)) {
            throw new InvalidInputException("ユーザーが存在しません。");
        }
        return siteUserDetail;
    }

    // ユーザー更新
    public void updateSiteUser(SiteUserUpdateRequest request, LocalDateTime now) {

        if (checkDuplicateCertification(request.getLoginId(), request.getPassword())) {
            throw new InvalidInputException("入力されたログインIDとパスワードはすでに利用されています。");
        }

        siteUserMapper.update(SiteUserUpdate.builder()
                .id(request.getId())
                .loginId(request.getLoginId())
                .userName(request.getUserName())
                .authority(request.getAuthority())
                .password(request.getPassword()) // TODO パスワードチェックか既存値か
                .updatedBy(0) // TODO ログインユーザID
                .updatedDt(now)
                .build());
    }

    // ユーザー論理削除
    public void deleteSiteUser(int id, LocalDateTime now) {
        siteUserMapper.updateDeleteFlg(id, 0, now);
    }

    public boolean checkDuplicateCertification(String loginId, String password) {
        return siteUserMapper.checkDuplicateCertification(loginId, password) > 0;
    }

}

package changeSeat.Service;

import changeSeat.Enum.EnumAuthority;
import changeSeat.Error.Exception.InvalidInputException;
import changeSeat.Mapper.SiteUserMapper;
import changeSeat.Model.SiteUser.SiteUserDetail;
import changeSeat.Model.SiteUser.SiteUserRegister;
import changeSeat.Model.SiteUser.SiteUserUpdate;
import changeSeat.Request.SiteUser.SiteUserListRequest;
import changeSeat.Request.SiteUser.SiteUserRegisterRequest;
import changeSeat.Request.SiteUser.SiteUserUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static java.util.Objects.isNull;

@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class SiteUserService {

    private final SiteUserMapper siteUserMapper;
    private final PasswordEncoder passwordEncoder;


    // 一覧取得
    public List<SiteUserDetail> getSiteUserList(SiteUserListRequest request) {
        return siteUserMapper.getSiteUserList(
                request.getLoginId(),
                request.getUserName(),
                request.getSchoolName(),
                Arrays.stream(Optional.ofNullable(request.getAuthority()).orElse(new String[]{"1", "2", "3"}))
                        .map(EnumAuthority::create).toList(),
                request.isAdmin(),
                request.getSchoolId());
    }

    // 登録
    public void registerSiteUser(SiteUserRegisterRequest request, LocalDateTime now) {
        try {
            if (!Objects.isNull(siteUserMapper.checkDuplicateLoginId(request.getLoginId(), null))) {
                throw new InvalidInputException("入力されたログインIDはすでに利用されています。");
            }
            siteUserMapper.insert(
                    SiteUserRegister.builder().
                            loginId(request.getLoginId())
                            .userName(request.getUserName())
                            .authority(request.getAuthority())
                            .password(passwordEncoder.encode(request.getPassword()))
                            .schoolId(request.getSchoolId())
                            .createdBy(request.getSiteUserId())
                            .createdDt(now)
                            .updatedBy(request.getSiteUserId())
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

        if (!Objects.isNull(siteUserMapper.checkDuplicateLoginId(request.getLoginId(), request.getUpdateSiteUserId()))) {
            throw new InvalidInputException("入力されたログインIDはすでに利用されています。");
        }

        siteUserMapper.update(SiteUserUpdate.builder()
                .updateSiteUserId(request.getUpdateSiteUserId())
                .loginId(request.getLoginId())
                .userName(request.getUserName())
                .authority(request.getAuthority())
                .password(request.getPassword() != null ? passwordEncoder.encode(request.getPassword()) : null)
                .schoolId(request.getSchoolId())
                .updatedBy(request.getSiteUserId())
                .updatedDt(now)
                .build());
    }

    // ユーザー論理削除
    public void deleteSiteUser(int siteUserId, int id, LocalDateTime now) {
        siteUserMapper.updateDeleteFlg(id, siteUserId, now);
    }

}

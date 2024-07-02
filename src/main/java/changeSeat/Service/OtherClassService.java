package changeSeat.Service;

import changeSeat.Error.Exception.NotFoundException;
import changeSeat.Mapper.OtherClassMapper;
import changeSeat.Model.OtherClass.OtherClassDetail;
import changeSeat.Model.OtherClass.OtherClassList;
import changeSeat.Model.OtherClass.OtherClassRegister;
import changeSeat.Request.OtherClass.OtherClassSearchRequest;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class OtherClassService {

    private final OtherClassMapper otherClassMapper;

    public List<OtherClassList> getMyOtherClassList(int siteUserId) {
        return otherClassMapper.getMyOtherClassList(siteUserId);
    }

    public List<OtherClassList> getOtherClassList(OtherClassSearchRequest request) {
        return otherClassMapper.getOtherClassList(
                request.getClassYear(),
                request.getClassName(),
                request.getTitle(),
                request.getSiteUserId(),
                request.getSchoolId()
        );
    }

    public void registerOtherClass(int siteUserId, int classId, LocalDateTime now) {

        try {
            otherClassMapper.insert(OtherClassRegister.builder()
                    .classId(classId)
                    .siteUserId(siteUserId)
                    .createdBy(siteUserId)
                    .createdDt(now)
                    .updatedBy(siteUserId)
                    .updatedDt(now)
                    .build());
        } catch (DuplicateKeyException e) {
            throw new DuplicateKeyException("データの登録に失敗しました。再度お試しください。", e.getCause());
        }
    }

    public void deleteOtherClass(int classId, int siteUserId, LocalDateTime now) {
        otherClassMapper.updateDeleteFlg(classId, siteUserId, now);
    }

    public OtherClassDetailDto getOtherClassDetail(int classId, int siteUserId, int schoolId) {
        var otherClassDetailList = otherClassMapper.getOtherClassDetail(classId, schoolId);

        if (otherClassDetailList.size() == 0) {
            throw new NotFoundException(String.format("classId：%d、schoolId:%dのクラスは存在しません。", classId, schoolId));
        }
        var a = otherClassMapper.checkMyOtherClass(classId, siteUserId);
        return OtherClassDetailDto.builder()
                .isMyOtherClass(otherClassMapper.checkMyOtherClass(classId, siteUserId))
                .otherClassDetails(otherClassDetailList).build();
    }


    @Data
    @Builder
    public static class OtherClassDetailDto {
        private boolean isMyOtherClass;

        private List<OtherClassDetail> otherClassDetails;
    }

}

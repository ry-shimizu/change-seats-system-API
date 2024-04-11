package changeSeat.Response.OtherClass;

import changeSeat.Enum.EnumSexType;
import changeSeat.Service.OtherClassService;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
public class OtherClassDetailResponse {

    private String className;

    private String title;

    private boolean isMyOtherClass;

    private List<SeatsInfo> seatsInfo;

    public OtherClassDetailResponse(OtherClassService.OtherClassDetailDto otherClassDetailDto) {
        setMyOtherClass(otherClassDetailDto.isMyOtherClass());
        var otherClassDetails = otherClassDetailDto.getOtherClassDetails();

        if (!otherClassDetails.isEmpty()) {
            setClassName(otherClassDetails.get(0).getClassName());
            setTitle(otherClassDetails.get(0).getTitle());

            setSeatsInfo(otherClassDetails.stream().map(oc -> SeatsInfo.builder()
                    .seatNumber(oc.getSeatNumber())
                    .sexType(oc.getSexType())
                    .studentName(oc.getStudentName())
                    .build()).collect(Collectors.toList()));
        }
    }

    @Data
    @Builder
    public static class SeatsInfo {
        private int seatNumber;

        private String studentName;

        private EnumSexType sexType;
    }
}

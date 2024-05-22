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

    private List<SeatsAddColInfo> seatsAddColInfo;

    public OtherClassDetailResponse(OtherClassService.OtherClassDetailDto otherClassDetailDto) {
        setMyOtherClass(otherClassDetailDto.isMyOtherClass());
        var otherClassDetails = otherClassDetailDto.getOtherClassDetails();

        if (!otherClassDetails.isEmpty()) {
            setClassName(otherClassDetails.get(0).getClassName());
            setTitle(otherClassDetails.get(0).getTitle());

            var groupedByTens = otherClassDetails.stream()
                    .map(oc -> SeatsInfo.builder()
                            .seatNumber(oc.getSeatNumber())
                            .sexType(oc.getSexType())
                            .studentName(oc.getStudentName())
                            .build())
                    .collect(Collectors.groupingBy(seatInfo -> seatInfo.getSeatNumber() / 10));

            setSeatsAddColInfo(groupedByTens.values().stream()
                    .map(seatsInfo -> SeatsAddColInfo.builder()
                            .seatsInfo(seatsInfo)
                            .build())
                    .toList());
        }
    }

    @Data
    @Builder
    public static class SeatsAddColInfo {
        private List<SeatsInfo> seatsInfo;

    }

    @Data
    @Builder
    public static class SeatsInfo {
        private int seatNumber;

        private String studentName;

        private EnumSexType sexType;
    }
}

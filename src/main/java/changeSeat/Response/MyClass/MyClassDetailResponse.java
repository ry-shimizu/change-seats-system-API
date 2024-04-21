package changeSeat.Response.MyClass;

import changeSeat.Enum.EnumSexType;
import changeSeat.Model.MyClass.MyClassDetail;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class MyClassDetailResponse {

    private String className;

    private String title;

    private List<MyClassDetailResponse.SeatsInfo> seatsInfo;

    public MyClassDetailResponse(List<MyClassDetail> myClassDetails) {

        if (!myClassDetails.isEmpty()) {
            setClassName(myClassDetails.get(0).getClassName());
            setTitle(myClassDetails.get(0).getTitle());

            setSeatsInfo(myClassDetails.stream().map(oc -> SeatsInfo.builder()
                    .seatId(oc.getSeatId())
                    .seatNumber(oc.getSeatNumber())
                    .sexType(oc.getSexType())
                    .studentName(oc.getStudentName())
                    .build()).collect(Collectors.toList()));
        }
    }

    @Data
    @Builder
    public static class SeatsInfo {

        private int seatId;

        private int seatNumber;

        private String studentName;

        private EnumSexType sexType;

        private int studentId;
    }
}

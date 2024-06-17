package changeSeat.Response.MyClass;

import changeSeat.Enum.EnumSeatStartPoint;
import changeSeat.Enum.EnumSexType;
import changeSeat.Model.MyClass.MyClassDetail;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Data
public class MyClassDetailResponse {

    private int classYear;

    private String className;

    private String title;

    private EnumSeatStartPoint seatStartPoint;

    private List<SeatsAddColInfo> seatsAddColInfo;

    public MyClassDetailResponse(List<MyClassDetail> myClassDetails) {

        if (!myClassDetails.isEmpty()) {
            setClassYear(myClassDetails.get(0).getClassYear());
            setClassName(myClassDetails.get(0).getClassName());
            setTitle(myClassDetails.get(0).getTitle());
            setSeatStartPoint(myClassDetails.get(0).getSeatStartPoint());

            var groupedByTens = myClassDetails.stream()
                    .map(c -> SeatsInfo.builder()
                            .seatId(c.getSeatId())
                            .seatNumber(c.getSeatNumber())
                            .studentId(c.getStudentId())
                            .sexType(c.getSexType())
                            .studentName(c.getStudentName())
                            .build())
                    .collect(Collectors.groupingBy(seatInfo -> seatInfo.getSeatNumber() / 10));

            setSeatsAddColInfo(groupedByTens.entrySet().stream()
                    .map(seatsInfo -> SeatsAddColInfo.builder()
                            .seatsInfo(seatsInfo.getValue())
                            .col(seatsInfo.getKey())
                            .build())
                    .sorted((a, b) -> {
                        if (Objects.equals(seatStartPoint.getValue(), "1")) {
                            return b.getCol() - a.getCol();
                        }
                        return a.getCol() - b.getCol();
                    })
                    .toList());
        }
    }

    @Data
    @Builder
    public static class SeatsAddColInfo {

        private int col;
        private List<SeatsInfo> seatsInfo;

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

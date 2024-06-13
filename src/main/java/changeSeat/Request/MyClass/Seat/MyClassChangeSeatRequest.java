package changeSeat.Request.MyClass.Seat;

import changeSeat.Enum.EnumSeatStartPoint;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class MyClassChangeSeatRequest {

    @NotNull
    private Integer classId;

    @NotNull
    private Integer siteUserId;

    @NotNull
    private Integer schoolId;

    @NotNull
    private EnumSeatStartPoint enumSeatStartPoint;

    @NotNull
    private List<ChangeSeatCondition> changeSeatConditionList;


    @Data
    public static class ChangeSeatCondition {

        @NotNull
        private Integer seatId;

        @NotNull
        private Integer studentId;

        @NotNull
        private EnumSeatStartPoint conditionX;

        private Integer positionXColumn;

        @NotNull
        private EnumSeatStartPoint conditionY;

        private Integer positionYColumn;
    }
}

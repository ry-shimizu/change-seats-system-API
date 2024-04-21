package changeSeat.Request.MyClass;

import changeSeat.Enum.EnumSeatStartPoint;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class MycClassRegisterRequest {

    @NotNull
    private Integer siteUserId;

    @NotNull
    private Integer year;

    @NotNull
    private String className;

    @NotNull
    private String title;

    @NotNull
    private EnumSeatStartPoint seatStartPoint;

    @NotNull
    private List<SeatNumber> seatNumberList;

    @Data
    public static class SeatNumber {

        @NotNull
        private Integer seatNum;
    }
}

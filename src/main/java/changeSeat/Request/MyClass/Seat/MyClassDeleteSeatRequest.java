package changeSeat.Request.MyClass.Seat;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class MyClassDeleteSeatRequest {

    @NotNull
    private Integer seatId;

    @NotNull
    private Integer classId;

    @NotNull
    private Integer studentId;

    @NotNull
    private Integer seatNumber;

}

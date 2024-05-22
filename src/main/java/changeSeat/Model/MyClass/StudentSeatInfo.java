package changeSeat.Model.MyClass;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StudentSeatInfo {
    private int seatId;

    private int studentId;

    private int seatNumber;
}

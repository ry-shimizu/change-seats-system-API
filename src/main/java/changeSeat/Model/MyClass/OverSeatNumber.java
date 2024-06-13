package changeSeat.Model.MyClass;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OverSeatNumber {

    private int seatId;

    private int seatNumber;
}

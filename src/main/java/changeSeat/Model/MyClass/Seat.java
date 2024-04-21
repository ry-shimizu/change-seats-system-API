package changeSeat.Model.MyClass;

import changeSeat.Enum.EnumFlagType;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class Seat {

    private int id;

    private int seatNumber;

    private int classId;

    private EnumFlagType emptySeatFlg;

    private int createdBy;

    private LocalDateTime createdDt;

    private int updatedBy;

    private LocalDateTime updatedDt;
}

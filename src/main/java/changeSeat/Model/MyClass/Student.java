package changeSeat.Model.MyClass;

import changeSeat.Enum.EnumSexType;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class Student {

    private String studentName;

    private EnumSexType sexType;

    private int seatId;

    private int createdBy;

    private LocalDateTime createdDt;

    private int updatedBy;

    private LocalDateTime updatedDt;
}

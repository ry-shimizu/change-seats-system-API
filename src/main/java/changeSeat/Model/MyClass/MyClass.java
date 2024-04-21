package changeSeat.Model.MyClass;

import changeSeat.Enum.EnumSeatStartPoint;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class MyClass {

    private int id;

    private String className;

    private String title;

    private int classYear;

    private EnumSeatStartPoint seatStartPoint;

    private int siteUserId;

    private int createdBy;

    private LocalDateTime createdDt;

    private int updatedBy;

    private LocalDateTime updatedDt;

}

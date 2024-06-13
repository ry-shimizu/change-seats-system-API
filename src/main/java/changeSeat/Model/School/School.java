package changeSeat.Model.School;

import changeSeat.Enum.EnumFlagType;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class School {
    private Integer id;

    private String schoolName;

    private EnumFlagType deleteFlg;

    private int createdBy;

    private LocalDateTime createdDt;

    private int updatedBy;

    private LocalDateTime updatedDt;

}

package changeSeat.Model.OtherClass;

import changeSeat.Enum.EnumFlagType;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class OtherClassRegister {

    private int siteUserId;

    private int classId;

    private EnumFlagType deleteFlg;

    private int createdBy;

    private LocalDateTime createdDt;

    private int updatedBy;

    private LocalDateTime updatedDt;
}

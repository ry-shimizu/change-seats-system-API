package changeSeat.Request.OtherClass;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class OtherClassDetailRequest {

    @NotNull
    private Integer siteUserId;

    @NotNull
    private Integer classId;
}

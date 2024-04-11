package changeSeat.Request.OtherClass;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class OtherClassRegisterRequest {

    @NotNull
    private Integer classId;

    @NotNull
    private Integer siteUserId;
}

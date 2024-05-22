package changeSeat.Request.OtherClass;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class OtherClassDeleteRequest {

    @NotNull
    private Integer classId;

    @NotNull
    private Integer siteUserId;
}

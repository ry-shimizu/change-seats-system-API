package changeSeat.Request.OtherClass;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class MyOtherClassListRequest {

    @NotNull
    private Integer siteUserId;
}

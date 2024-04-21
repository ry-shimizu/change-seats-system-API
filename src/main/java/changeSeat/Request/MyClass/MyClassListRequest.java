package changeSeat.Request.MyClass;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class MyClassListRequest {

    @NotNull
    private Integer siteUserId;

}

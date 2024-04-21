package changeSeat.Request.MyClass;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class MyClassDetailRequest {

    @NotNull
    private Integer classId;
    
    @NotNull
    private Integer siteUserId;
}

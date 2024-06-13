package changeSeat.Request.MyClass;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class MyClassDeleteRequest {
    @NotNull
    private Integer classId;

    @NotNull
    private Integer siteUserId;

    @NotNull
    private Integer schoolId;

}

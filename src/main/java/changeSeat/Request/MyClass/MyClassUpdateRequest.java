package changeSeat.Request.MyClass;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class MyClassUpdateRequest {

    @NotNull
    private Integer siteUserId;

    @NotNull
    private Integer classId;

    @NotNull
    private Integer schoolId;

    @NotNull
    private String className;

    @NotNull
    private Integer classYear;

    @NotNull
    private String title;

}

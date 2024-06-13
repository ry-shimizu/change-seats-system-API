package changeSeat.Request.OtherClass;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class OtherClassSearchRequest {

    @NotNull
    private Integer siteUserId;

    private Integer schoolId;

    private Integer classYear;

    private String className;

    private String title;
}

package changeSeat.Request.SiteUser;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class SiteUserDeleteRequest {

    @NotNull
    private Integer id;
}

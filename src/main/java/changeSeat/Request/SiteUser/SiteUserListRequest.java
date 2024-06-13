package changeSeat.Request.SiteUser;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class SiteUserListRequest {
    private String loginId;

    private String userName;

    private String schoolName;

    private String[] authority;

    @NotNull
    private Integer schoolId;

    @NotNull
    @JsonProperty("isAdmin")
    private boolean isAdmin;
}

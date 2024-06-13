package changeSeat.Request.SiteUser;

import changeSeat.Enum.EnumAuthority;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class SiteUserUpdateRequest {
    @NotNull
    private Integer updateSiteUserId;

    @NotNull
    private Integer loginSiteUserId;

    @NotBlank
    @Pattern(regexp = "^[a-zA-Z0-9 ]*$")
    @Size(max = 30)
    private String loginId;

    @NotNull
    private EnumAuthority authority;

    @NotBlank
    @Size(max = 40)
    private String userName;

    private String password;

    @NotNull
    private Integer schoolId;
}

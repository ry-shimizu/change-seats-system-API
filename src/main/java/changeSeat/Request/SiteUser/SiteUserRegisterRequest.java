package changeSeat.Request.SiteUser;

import changeSeat.Enum.EnumAuthority;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class SiteUserRegisterRequest {

    @NotNull
    private Integer siteUserId;

    @NotBlank
    @Pattern(regexp = "^[a-zA-Z0-9-_]*$")
    @Size(max = 30)
    private String loginId;

    @NotNull
    private EnumAuthority authority;

    @NotNull
    private Integer schoolId;

    @NotBlank
    @Size(max = 40)
    private String userName;

    @Size(min = 10)
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z0-9-_]*$")
    private String password;
}

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
    @Pattern(regexp = "^[a-zA-Z0-9-]*$")
    @Size(max = 30)
    private String loginId;

    @NotNull
    private EnumAuthority authority;

    @NotNull
    private Integer registerSchoolId;

    @NotBlank
    @Size(max = 40)
    private String userName;

    @Size(min = 10, max = 255)
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z0-9]*$")
    private String password;
}

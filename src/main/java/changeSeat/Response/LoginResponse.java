package changeSeat.Response;

import changeSeat.Enum.EnumAuthority;
import changeSeat.Model.LoginUser;
import lombok.Data;

@Data
public class LoginResponse {

    public LoginResponse(LoginUser loginUser) {
        setSiteUserId(loginUser.getSiteUserId());
        setSchoolId(loginUser.getSchoolId());
        setAuthority(loginUser.getAuthority());
    }

    private Integer siteUserId;

    private Integer schoolId;

    private EnumAuthority authority;
}

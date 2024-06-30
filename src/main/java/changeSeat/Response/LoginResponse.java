package changeSeat.Response;

import changeSeat.Enum.EnumAuthority;
import changeSeat.Model.SiteUser.SiteUserDetail;
import lombok.Data;

@Data
public class LoginResponse {

    public LoginResponse(SiteUserDetail userDetail) {
        setSiteUserId(userDetail.getId());
        setSchoolId(userDetail.getSchoolId());
        setAuthority(userDetail.getAuthority());
    }

    private Integer siteUserId;

    private Integer schoolId;

    private EnumAuthority authority;
}

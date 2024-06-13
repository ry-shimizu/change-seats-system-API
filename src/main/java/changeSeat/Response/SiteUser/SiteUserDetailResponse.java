package changeSeat.Response.SiteUser;

import changeSeat.Enum.EnumAuthority;
import changeSeat.Enum.EnumFlagType;
import changeSeat.Model.SiteUser.SiteUserDetail;
import lombok.Data;

@Data
public class SiteUserDetailResponse {
    private int id;
    private String loginId;
    private String userName;
    private EnumAuthority authority;
    private EnumFlagType deleteFlg;
    private int schoolId;

    public SiteUserDetailResponse(SiteUserDetail siteUserDetail) {
        this.id = siteUserDetail.getId();
        this.loginId = siteUserDetail.getLoginId();
        this.userName = siteUserDetail.getUserName();
        this.authority = siteUserDetail.getAuthority();
        this.deleteFlg = siteUserDetail.getDeleteFlg();
        this.schoolId = siteUserDetail.getSchoolId();
    }
}

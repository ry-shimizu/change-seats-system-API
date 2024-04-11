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

    public SiteUserDetailResponse(SiteUserDetail siteUserDetailDto) {
        this.id = siteUserDetailDto.getId();
        this.loginId = siteUserDetailDto.getLoginId();
        this.userName = siteUserDetailDto.getUserName();
        this.authority = siteUserDetailDto.getAuthority();
        this.deleteFlg = siteUserDetailDto.getDeleteFlg();
    }
}

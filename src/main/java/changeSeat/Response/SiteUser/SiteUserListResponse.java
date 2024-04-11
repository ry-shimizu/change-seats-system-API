package changeSeat.Response.SiteUser;

import changeSeat.Model.SiteUser.SiteUserDetail;
import lombok.Data;

import java.util.List;

@Data
public class SiteUserListResponse {

    List<SiteUserDetail> siteUserDetailList;

    public SiteUserListResponse(List<SiteUserDetail> siteUserDetailList) {
        this.siteUserDetailList = siteUserDetailList;
    }
}

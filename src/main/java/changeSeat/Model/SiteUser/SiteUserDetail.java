package changeSeat.Model.SiteUser;

import changeSeat.Enum.EnumAuthority;
import changeSeat.Enum.EnumFlagType;
import lombok.Data;

@Data
public class SiteUserDetail {

    private int id;

    private String loginId;

    private String userName;

    private EnumAuthority authority;

    private EnumFlagType deleteFlg;

    private String schoolName;

    private int schoolId;

    private String password;
}

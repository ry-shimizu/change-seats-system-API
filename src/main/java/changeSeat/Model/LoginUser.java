package changeSeat.Model;

import changeSeat.Enum.EnumAuthority;
import lombok.Data;

@Data
public class LoginUser {

    private int siteUserId;

    private int schoolId;

    private EnumAuthority authority;
}

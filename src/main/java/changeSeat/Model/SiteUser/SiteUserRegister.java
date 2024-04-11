package changeSeat.Model.SiteUser;

import changeSeat.Enum.EnumAuthority;
import changeSeat.Enum.EnumFlagType;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class SiteUserRegister {

    private int id;

    private String loginId;

    private String userName;

    private EnumAuthority authority;

    private String password;

    private EnumFlagType deleteFlg;

    private int createdBy;

    private LocalDateTime createdDt;

    private int updatedBy;

    private LocalDateTime updatedDt;
}

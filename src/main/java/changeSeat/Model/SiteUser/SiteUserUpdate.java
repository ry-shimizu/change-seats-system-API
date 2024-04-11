package changeSeat.Model.SiteUser;

import changeSeat.Enum.EnumAuthority;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class SiteUserUpdate {
    private int id;

    private String loginId;

    private String userName;

    private EnumAuthority authority;

    private String password;

    private int updatedBy;

    private LocalDateTime updatedDt;
}

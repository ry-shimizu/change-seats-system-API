package com.changeSeat.Model;

import com.changeSeat.Enum.EnumAuthority;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class SiteUser {

    private String loginId;

    private String userName;

    private EnumAuthority authority;

    private String password;

    private int created_by;

    private LocalDateTime created_dt;

    private int updated_by;

    private LocalDateTime updated_at;
}

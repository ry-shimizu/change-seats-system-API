package com.changeSeat.Request;

import com.changeSeat.Enum.EnumAuthority;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class SiteUserRegisterRequest {

    @NotBlank
    @Pattern(regexp = "^[a-zA-Z0-9 ]*$")
    @Max(30)
    private String loginId;

    @NotNull
    private EnumAuthority authority;

    @NotBlank
    @Max(40)
    private String userName;

    @NotBlank
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9]){8,48}$")
    private String password;
}

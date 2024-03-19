package com.changeSeat.Request;

import com.changeSeat.Enum.AuthorityEnum;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class UserRegisterRequest {

    @NotBlank
    private String loginId;

    @NotBlank
    private AuthorityEnum authority;

    @NotBlank
    @Max(40)
    private String userName;

    @NotBlank

    private String password;
}

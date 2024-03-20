package com.changeSeat.Controller;

import com.changeSeat.Request.SiteUserRegisterRequest;
import com.changeSeat.Service.SiteUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RequestMapping("/site-user")
@RestController
@RequiredArgsConstructor
public class SiteUserController {

    private final SiteUserService siteUserService;

    @PostMapping("/register")
    public ResponseEntity siteUserRegister(@RequestBody @Validated SiteUserRegisterRequest request) {
        var now = LocalDateTime.now();
        return siteUserService.siteUserRegister(request, now);
    }

}

package changeSeat.Controller;

import changeSeat.Request.LoginRequest;
import changeSeat.Response.LoginResponse;
import changeSeat.Service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @PostMapping("/login")
    public LoginResponse login(@RequestBody @Validated LoginRequest loginRequest) {
        return new LoginResponse(loginService.login(loginRequest.getLoginId(), loginRequest.getPassword()));
    }
}

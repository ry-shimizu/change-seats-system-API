package changeSeat.Service;

import changeSeat.Error.Exception.UnauthorizedException;
import changeSeat.Mapper.LoginMapper;
import changeSeat.Model.LoginUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final LoginMapper loginMapper;

    public LoginUser login(String loginId, String password) {
        return Optional.ofNullable(loginMapper.login(loginId, password))
                .orElseThrow(() -> {
                    throw new UnauthorizedException("ログインId、もしくはパスワードに誤りがあります。");
                });
    }
}

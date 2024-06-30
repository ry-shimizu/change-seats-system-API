package changeSeat.Service;

import changeSeat.Error.Exception.UnauthorizedException;
import changeSeat.Mapper.SiteUserMapper;
import changeSeat.Model.SiteUser.SiteUserDetail;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoginService {
    private final SiteUserMapper siteUserMapper;

    private final PasswordEncoder passwordEncoder;


    public SiteUserDetail login(String loginId, String password) {
        var a = passwordEncoder.encode(password);
        var user = Optional.ofNullable(siteUserMapper.checkDuplicateLoginId(loginId, null))
                .orElseThrow(() -> {
                    throw new UnauthorizedException("ログインId、もしくはパスワードに誤りがあります。");
                });
        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new UnauthorizedException("ログインId、もしくはパスワードに誤りがあります。");
        }

        return user;
    }
}

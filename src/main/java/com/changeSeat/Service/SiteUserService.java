package com.changeSeat.Service;

import com.changeSeat.Mapper.SiteUserMapper;
import com.changeSeat.Model.SiteUser;
import com.changeSeat.Request.SiteUserRegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class SiteUserService {

    private final SiteUserMapper siteUserMapper;

    public ResponseEntity siteUserRegister(SiteUserRegisterRequest request, LocalDateTime now) {
        siteUserMapper.insert(
                SiteUser.builder().
                        loginId(request.getLoginId())
                        .userName(request.getUserName())
                        .authority(request.getAuthority())
                        .password(request.getPassword())
                        .created_by(0)
                        .created_dt(now)
                        .updated_by(0)
                        .updated_at(now)
                        .build());
        return ResponseEntity.ok().build();
    }
}

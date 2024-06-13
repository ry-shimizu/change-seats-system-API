package changeSeat.Controller;

import changeSeat.Request.SiteUser.SiteUserDeleteRequest;
import changeSeat.Request.SiteUser.SiteUserListRequest;
import changeSeat.Request.SiteUser.SiteUserRegisterRequest;
import changeSeat.Request.SiteUser.SiteUserUpdateRequest;
import changeSeat.Response.SiteUser.SiteUserDetailResponse;
import changeSeat.Response.SiteUser.SiteUserListResponse;
import changeSeat.Service.SiteUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RequestMapping("/siteUser")
@RestController
@RequiredArgsConstructor
public class SiteUserController {

    private final SiteUserService siteUserService;

    @PostMapping("/")
    public SiteUserListResponse getSiteUserList(@RequestBody @Validated SiteUserListRequest request) {
        return new SiteUserListResponse(siteUserService.getSiteUserList(request));
    }

    @PostMapping("/register")
    public ResponseEntity<Void> registerSiteUser(@RequestBody @Validated SiteUserRegisterRequest request) {
        siteUserService.registerSiteUser(request, LocalDateTime.now());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/detail/{id}")
    public SiteUserDetailResponse getSiteUserDetail(@PathVariable int id) {
        return new SiteUserDetailResponse(siteUserService.getSiteUserDetail(id));
    }

    @PutMapping("/update")
    public ResponseEntity<Void> updateSiteUser(@RequestBody @Validated SiteUserUpdateRequest request) {
        siteUserService.updateSiteUser(request, LocalDateTime.now());
        return ResponseEntity.ok().build();
    }

    @PutMapping("/delete")
    public ResponseEntity<Void> deleteSiteUser(@RequestBody @Validated SiteUserDeleteRequest request) {
        siteUserService.deleteSiteUser(request.getId(), LocalDateTime.now());
        return ResponseEntity.ok().build();
    }
}

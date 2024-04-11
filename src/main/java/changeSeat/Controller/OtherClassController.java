package changeSeat.Controller;

import changeSeat.Request.OtherClass.MyOtherClassListRequest;
import changeSeat.Request.OtherClass.OtherClassDeleteRequest;
import changeSeat.Request.OtherClass.OtherClassRegisterRequest;
import changeSeat.Request.OtherClass.OtherClassSearchRequest;
import changeSeat.Response.OtherClass.OtherClassDetailResponse;
import changeSeat.Response.OtherClass.OtherClassListResponse;
import changeSeat.Service.OtherClassService;
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

@RequestMapping("/otherClass")
@RestController
@RequiredArgsConstructor
public class OtherClassController {

    private final OtherClassService otherClassService;

    @PostMapping("/myList")
    public OtherClassListResponse getMyOtherClassList(@RequestBody @Validated MyOtherClassListRequest request) {
        return new OtherClassListResponse(otherClassService.getMyOtherClassList(request.getSiteUserId()));
    }

    @PostMapping("/search")
    public OtherClassListResponse getOtherClassList(@RequestBody OtherClassSearchRequest request) {
        return new OtherClassListResponse(otherClassService.getOtherClassList(request));
    }

    @PostMapping("/register")
    public ResponseEntity<Void> registerOtherClass(@RequestBody @Validated OtherClassRegisterRequest request) {
        var now = LocalDateTime.now();
        otherClassService.registerOtherClass(request.getSiteUserId(), request.getClassId(), now);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/delete")
    public ResponseEntity<Void> deleteOtherClass(@RequestBody @Validated OtherClassDeleteRequest request) {
        var now = LocalDateTime.now();
        otherClassService.deleteOtherClass(request.getOtherClassId(), now);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/detail/{classId}/{siteUserId}")
    public OtherClassDetailResponse getOtherClassDetail(@PathVariable int classId, @PathVariable int siteUserId) {
        return new OtherClassDetailResponse(otherClassService.getOtherClassDetail(classId, siteUserId));
    }

}

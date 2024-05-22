package changeSeat.Controller;

import changeSeat.Request.OtherClass.MyOtherClassListRequest;
import changeSeat.Request.OtherClass.OtherClassDeleteRequest;
import changeSeat.Request.OtherClass.OtherClassDetailRequest;
import changeSeat.Request.OtherClass.OtherClassRegisterRequest;
import changeSeat.Request.OtherClass.OtherClassSearchRequest;
import changeSeat.Response.OtherClass.OtherClassDetailResponse;
import changeSeat.Response.OtherClass.OtherClassListResponse;
import changeSeat.Service.OtherClassService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
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
        otherClassService.registerOtherClass(request.getSiteUserId(), request.getClassId(), LocalDateTime.now());
        return ResponseEntity.ok().build();
    }

    @PutMapping("/delete")
    public ResponseEntity<Void> deleteOtherClass(@RequestBody @Validated OtherClassDeleteRequest request) {
        otherClassService.deleteOtherClass(request.getClassId(), request.getSiteUserId(), LocalDateTime.now());
        return ResponseEntity.ok().build();
    }

    @PostMapping("/detail")
    public OtherClassDetailResponse getOtherClassDetail(@RequestBody @Validated OtherClassDetailRequest request) {
        return new OtherClassDetailResponse(otherClassService.getOtherClassDetail(request.getClassId(), request.getSiteUserId()));
    }

}

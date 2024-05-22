package changeSeat.Controller;

import changeSeat.Request.MyClass.MyClassDetailRequest;
import changeSeat.Request.MyClass.MyClassListRequest;
import changeSeat.Request.MyClass.MycClassRegisterRequest;
import changeSeat.Request.MyClass.Seat.MyClassChangeSeatRequest;
import changeSeat.Request.MyClass.Seat.MyClassDeleteSeatRequest;
import changeSeat.Request.MyClass.Seat.MyClassUpdateSeatRequest;
import changeSeat.Response.MyClass.MyClassDetailResponse;
import changeSeat.Response.MyClass.MyClassListResponse;
import changeSeat.Service.MyClassService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
@RequestMapping("/myClass")
public class MyClassController {

    private final MyClassService myClassService;

    @PostMapping("/")
    public MyClassListResponse getMyClassList(@RequestBody @Validated MyClassListRequest request) {
        return new MyClassListResponse(myClassService.getMyClassList(request.getSiteUserId()));
    }

    @PostMapping("/register")
    public ResponseEntity<Void> registerMyClass(@RequestPart("file") MultipartFile multipartFile, @RequestPart("data") @Validated MycClassRegisterRequest request) {
        myClassService.registerMyClass(multipartFile, request, LocalDateTime.now());
        return ResponseEntity.ok().build();
    }

    @PostMapping("/detail")
    public MyClassDetailResponse getMyClassDetail(@RequestBody @Validated MyClassDetailRequest request) {
        return new MyClassDetailResponse(myClassService.getMyClassDetail(request.getClassId(), request.getSiteUserId()));
    }

    @PostMapping("/update/seat")
    public ResponseEntity<Void> updateSeat(@RequestBody @Validated MyClassUpdateSeatRequest request) {
        myClassService.updateSeat(request, LocalDateTime.now());
        return ResponseEntity.ok().build();
    }

    @PostMapping("/delete/seat")
    public ResponseEntity<Void> deleteSeat(@RequestBody @Validated MyClassDeleteSeatRequest request) {
        myClassService.deleteSeat(request, LocalDateTime.now());
        return ResponseEntity.ok().build();
    }

    @PostMapping("/change/seat")
    public MyClassDetailResponse changeSeat(@RequestBody @Validated MyClassChangeSeatRequest request) {
        return new MyClassDetailResponse(myClassService.changeSeat(request, LocalDateTime.now()));
    }

}

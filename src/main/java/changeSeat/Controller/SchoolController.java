package changeSeat.Controller;

import changeSeat.Response.SchoolListResponse;
import changeSeat.Service.SchoolService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/school")
@RequiredArgsConstructor
public class SchoolController {

    private final SchoolService schoolService;

    @GetMapping("/")
    public SchoolListResponse getSchoolList() {
        return new SchoolListResponse(schoolService.getSchoolList());
    }
}

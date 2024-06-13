package changeSeat.Response;

import changeSeat.Model.School.SchoolDetail;
import lombok.Data;

import java.util.List;

@Data
public class SchoolListResponse {

    List<SchoolDetail> schoolDetailList;

    public SchoolListResponse(List<SchoolDetail> schoolDetailList) {
        this.schoolDetailList = schoolDetailList;
    }

}

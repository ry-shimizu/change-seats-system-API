package changeSeat.Service;

import changeSeat.Mapper.SchoolMapper;
import changeSeat.Model.School.SchoolDetail;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SchoolService {

    private final SchoolMapper schoolMapper;

    public List<SchoolDetail> getSchoolList() {
        return schoolMapper.getSchoolList();
    }
}

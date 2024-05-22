package changeSeat.Response.OtherClass;

import changeSeat.Model.OtherClass.OtherClassList;
import lombok.Data;

import java.util.List;

@Data
public class OtherClassListResponse {
    List<OtherClassList> classList;

    public OtherClassListResponse(List<OtherClassList> otherClassList) {
        this.classList = otherClassList;
    }
}

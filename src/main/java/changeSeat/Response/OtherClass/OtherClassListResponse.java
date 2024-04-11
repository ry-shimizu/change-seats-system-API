package changeSeat.Response.OtherClass;

import changeSeat.Model.OtherClass.OtherClassList;
import lombok.Data;

import java.util.List;

@Data
public class OtherClassListResponse {
    List<OtherClassList> otherClassList;

    public OtherClassListResponse(List<OtherClassList> otherClassList) {
        this.otherClassList = otherClassList;
    }
}

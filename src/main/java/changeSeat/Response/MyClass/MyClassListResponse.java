package changeSeat.Response.MyClass;

import changeSeat.Model.MyClass.MyClassList;
import lombok.Data;

import java.util.List;

@Data
public class MyClassListResponse {
    List<MyClassList> classList;

    public MyClassListResponse(List<MyClassList> myClassList) {
        this.classList = myClassList;
    }
}

package changeSeat.Response.MyClass;

import changeSeat.Model.MyClass.MyClassList;
import lombok.Data;

import java.util.List;

@Data
public class MyClassListResponse {
    List<MyClassList> myClassList;

    public MyClassListResponse(List<MyClassList> myClassList) {
        this.myClassList = myClassList;
    }
}

package changeSeat.Model.MyClass;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MyClassList {

    private int classYear;

    private String className;

    private String title;

    private int studentNum;

    private LocalDateTime updatedDt;
}

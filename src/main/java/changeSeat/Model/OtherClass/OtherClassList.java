package changeSeat.Model.OtherClass;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OtherClassList {

    private int classId;

    private int classYear;

    private String className;

    private String title;

    private int studentNum;

    private LocalDateTime updatedDt;

}

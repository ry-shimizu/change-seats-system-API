package changeSeat.Model.MyClass;

import changeSeat.Enum.EnumSeatStartPoint;
import changeSeat.Enum.EnumSexType;
import lombok.Data;

@Data
public class MyClassDetail {

    private int classYear;

    private String className;

    private String title;

    private EnumSeatStartPoint seatStartPoint;

    private int seatId;

    private int seatNumber;

    private String studentName;

    private EnumSexType sexType;

    private int studentId;
}

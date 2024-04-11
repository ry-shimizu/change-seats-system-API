package changeSeat.Model.OtherClass;

import changeSeat.Enum.EnumSexType;
import lombok.Data;

@Data
public class OtherClassDetail {

    private String className;

    private String title;

    private int seatNumber;

    private String studentName;

    private EnumSexType sexType;

}

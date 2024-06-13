package changeSeat.Request.MyClass.Seat;

import changeSeat.Enum.EnumSexType;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

@Data
public class MyClassRegisterSeatRequest {

    @NotNull
    private Integer classId;

    @NotNull
    private Integer siteUserId;

    @NotNull
    private Integer seatNumber;

    private String studentName;

    @NotNull
    private EnumSexType sexType;

    @NotNull
    @JsonProperty("isEmptySeat")
    private boolean isEmptySeat;

    @AssertTrue(message = "空席設定されていない場合、Student Nameは必須です。")
    public boolean isStudentEmpty() {
        return !(!isEmptySeat && StringUtils.isEmpty(studentName));
    }
}

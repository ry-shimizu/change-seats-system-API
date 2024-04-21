package changeSeat.Request.MyClass;

import changeSeat.Enum.EnumSexType;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Objects;

@Data
public class MyClassUpdateSeatRequest {

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
        return isEmptySeat || !Objects.isNull(studentName);
    }
}

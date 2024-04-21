package changeSeat.Request.MyClass;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class MyClassDeleteSeatRequest {

    @NotNull
    private Integer seatId;

    @NotNull
    private Integer classId;

    @NotNull
    private Integer studentId;

    @NotNull
    private Integer siteUserId;

    @NotNull
    private Integer seatNumber;

    @NotNull
    @JsonProperty("isEmptySeat")
    private boolean isEmptySeat;
}

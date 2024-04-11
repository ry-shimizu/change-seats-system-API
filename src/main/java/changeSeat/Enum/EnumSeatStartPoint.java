package changeSeat.Enum;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.stream.Stream;

public enum EnumSeatStartPoint {
    RIGHT(1),
    LEFT(2);

    private int value;

    private EnumSeatStartPoint(int value) {
        this.value = value;
    }

    @JsonValue
    public int getValue() {
        return this.value;
    }

    @JsonCreator
    public EnumSeatStartPoint crete(Integer value) {
        return Stream.of(EnumSeatStartPoint.values())
                .filter(v -> value.equals(v.getValue()))
                .findFirst().orElseThrow(IllegalArgumentException::new);
    }
}

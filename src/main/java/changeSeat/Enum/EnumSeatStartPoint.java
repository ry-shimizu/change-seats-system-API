package changeSeat.Enum;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.stream.Stream;

public enum EnumSeatStartPoint {
    RIGHT("1"),
    LEFT("2"),
    BEFORE("3"),
    AFTER("4");

    private final String value;

    private EnumSeatStartPoint(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return this.value;
    }

    @JsonCreator
    public EnumSeatStartPoint crete(String value) {
        return Stream.of(EnumSeatStartPoint.values())
                .filter(v -> value.equals(v.getValue()))
                .findFirst().orElseThrow(IllegalArgumentException::new);
    }
}

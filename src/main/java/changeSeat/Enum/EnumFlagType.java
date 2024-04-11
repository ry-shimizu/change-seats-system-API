package changeSeat.Enum;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Objects;
import java.util.stream.Stream;

public enum EnumFlagType {
    FLAG_ON(1),
    FLAG_OFF(0);

    private int value;

    private EnumFlagType(int value) {
        this.value = value;
    }

    @JsonValue
    public int getValue() {
        return value;
    }

    @JsonCreator
    public EnumFlagType create(Integer value) {
        if (Objects.isNull(value)) {
            return null;
        }
        return Stream.of(EnumFlagType.values())
                .filter(v -> value.equals(v.getValue()))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}

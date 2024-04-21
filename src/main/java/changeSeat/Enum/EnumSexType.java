package changeSeat.Enum;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.stream.Stream;

import static java.util.Objects.isNull;

public enum EnumSexType {
    MAN(1),
    WOMAN(2),
    OTHER(3);

    private final int value;

    private EnumSexType(int value) {
        this.value = value;
    }

    @JsonValue
    public int getValue() {
        return value;
    }

    @JsonCreator
    public EnumSexType create(Integer value) {
        if (isNull(value)) {
            return null;
        }
        return Stream.of(values())
                .filter(v -> value.equals(v.getValue()))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public static EnumSexType getEnumSexType(int value) {
        return Stream.of(values())
                .filter(v -> value == v.getValue())
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}

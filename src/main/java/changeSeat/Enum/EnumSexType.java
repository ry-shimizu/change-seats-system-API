package changeSeat.Enum;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Objects;
import java.util.stream.Stream;

import static java.util.Objects.isNull;

public enum EnumSexType {
    MAN("1"),
    WOMAN("2"),
    OTHER("3");

    private final String value;

    private EnumSexType(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @JsonCreator
    public EnumSexType create(String value) {
        if (isNull(value)) {
            return null;
        }
        return Stream.of(values())
                .filter(v -> value.equals(v.getValue()))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public static EnumSexType getEnumSexType(String value) {
        return Stream.of(values())
                .filter(v -> Objects.equals(value, v.getValue()))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}

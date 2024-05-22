package changeSeat.Enum;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.stream.Stream;

import static java.util.Objects.isNull;

public enum EnumAuthority {
    SCHOOL_ADMIN("1"),
    GENERAL("2"),
    MASTER("3");

    private final String value;

    private EnumAuthority(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @JsonCreator
    public static EnumAuthority create(String value) {
        if (isNull(value)) {
            return null;
        }
        return Stream.of(values())
                .filter(v -> value.equals(v.getValue()))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}

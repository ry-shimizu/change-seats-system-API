package changeSeat.Enum;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Objects;
import java.util.stream.Stream;

public enum EnumFlagType {

    FLAG_OFF("0"), FLAG_ON("1");

    private final String value;

    private EnumFlagType(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @JsonCreator
    public EnumFlagType create(String value) {
        if (Objects.isNull(value)) {
            return null;
        }
        return Stream.of(EnumFlagType.values())
                .filter(v -> value.equals(v.getValue()))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}

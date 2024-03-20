package com.changeSeat.Enum;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.stream.Stream;

public enum EnumAuthority {
    ADMIN(1),
    GENERAL(2);

    private int value;

    private EnumAuthority(int value) {
        this.value = value;
    }

    @JsonValue
    public int getValue() {
        return value;
    }

    @JsonCreator
    public static EnumAuthority create(Integer value) {
        if (value == null) {
            return null;
        }
        return Stream.of(values())
                .filter(v -> value.equals(v.getValue()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException());
    }
}

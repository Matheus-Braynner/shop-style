package io.github.matheusbraynner.mscatalog.entities.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Size {

    PP("pp"),
    P("p"),
    M("m"),
    G("g"),
    GG("gg");

    private final String size;

    public static Size toEnum(String value) {
        if (value == null) {
            return null;
        }

        for (Size x: Size.values()) {
            if (value.equals(x.getSize())) {
                return x;
            }
        }
        throw new IllegalArgumentException("Size invalid " + value + ".");
    }
}

package io.github.matheusbraynner.ms_customer.entities.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Sex {
    MAN("man"),
    WOMAN("woman");

    private final String sex;

    public static Sex toEnum(String value) {
        if (value == null) {
            return null;
        }

        for (Sex x: Sex.values()) {
            if (value.equals(x.getSex())) {
                return x;
            }
        }
        throw new IllegalArgumentException("Sex invalid " + value + ".");
    }
}

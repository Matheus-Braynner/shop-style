package io.github.matheusbraynner.ms_customer.services.exceptions;

import java.io.Serial;

public class InvalidLoginException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = -8425181348859867759L;

    public InvalidLoginException(String msg) {
        super(msg);
    }
}

package io.github.matheusbraynner.ms_customer.controllers.handler;

import java.io.Serial;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError{

    @Serial
    private static final long serialVersionUID = 4500891001329457770L;

    private final List<FieldName> errors = new ArrayList<>();

    public ValidationError(Instant timestamp, Integer status, String error, String message, String path) {
        super(timestamp, status, error, message, path);
    }

    public void addError(String fieldName, String message) {
        errors.add(new FieldName(fieldName, message));
    }
}

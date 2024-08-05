package io.github.matheusbraynner.mscatalog.controllers.handler;

import java.io.Serial;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError{

    @Serial
    private static final long serialVersionUID = 6662424347195876189L;

    private final List<FieldName> errors = new ArrayList<>();

    public ValidationError(Instant timestamp, Integer status, String error, String message, String path) {
        super(timestamp, status, error, message, path);
    }

    public void addError(String fieldName, String message) {
        errors.add(new FieldName(fieldName, message));
    }
}

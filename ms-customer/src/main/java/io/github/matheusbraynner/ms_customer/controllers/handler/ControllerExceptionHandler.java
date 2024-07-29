package io.github.matheusbraynner.ms_customer.controllers.handler;

import io.github.matheusbraynner.ms_customer.services.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.postgresql.util.PSQLException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;
import java.util.Objects;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandardError> validation(MethodArgumentNotValidException e, HttpServletRequest request) {
        String error = "Validation error";
        String message = Objects.requireNonNull(e.getFieldError()).getField() + " " + e.getFieldError().getDefaultMessage();
        HttpStatus status = HttpStatus.BAD_REQUEST;
        ValidationError err = new ValidationError(Instant.now(), status.value(), error, message, request.getRequestURI());
        for (FieldError x : e.getBindingResult().getFieldErrors()) {
            err.addError(x.getField(), x.getDefaultMessage());
        }

        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> resourceNotFoundException(ResourceNotFoundException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        String message = "Resource not found";
        StandardError err = new StandardError(Instant.now(), status.value(), e.getMessage(), message, request.getRequestURI());

        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(PSQLException.class)
    public ResponseEntity<StandardError> psqlException(PSQLException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        String message = "Database error";
        StandardError err = new StandardError(Instant.now(), status.value(), e.getMessage(), message, request.getRequestURI());

        return ResponseEntity.status(status).body(err);
    }
}

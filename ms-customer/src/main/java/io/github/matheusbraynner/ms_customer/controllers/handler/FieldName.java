package io.github.matheusbraynner.ms_customer.controllers.handler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FieldName implements Serializable {

    @Serial
    private static final long serialVersionUID = 4540710915292017615L;

    private String fieldName;
    private String message;
}

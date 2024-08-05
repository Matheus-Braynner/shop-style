package io.github.matheusbraynner.mscatalog.controllers.handler;

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
    private static final long serialVersionUID = -5494053416980460143L;

    private String fieldName;
    private String message;
}

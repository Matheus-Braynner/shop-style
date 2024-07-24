package io.github.matheusbraynner.ms_customer.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChangePasswordFormsDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 9189063159976268997L;

    @NotNull
    @Min(value = 6)
    private String password;
}

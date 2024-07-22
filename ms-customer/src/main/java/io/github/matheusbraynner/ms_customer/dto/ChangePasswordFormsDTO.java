package io.github.matheusbraynner.ms_customer.dto;

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

    private String password;
}

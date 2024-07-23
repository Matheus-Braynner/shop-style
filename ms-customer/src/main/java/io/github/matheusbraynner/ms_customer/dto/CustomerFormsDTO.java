package io.github.matheusbraynner.ms_customer.dto;

import io.github.matheusbraynner.ms_customer.entities.enums.Sex;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerFormsDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 5490378330342920212L;

    private String cpf;

    private String firstName;

    private String lastName;

    private Sex sex;

    private LocalDate birthdate;

    private String email;

    private String password;

    private Boolean active;
}

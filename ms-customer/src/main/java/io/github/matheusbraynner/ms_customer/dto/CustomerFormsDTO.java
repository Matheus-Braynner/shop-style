package io.github.matheusbraynner.ms_customer.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.github.matheusbraynner.ms_customer.entities.enums.Sex;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

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

    @CPF
    @NotNull
    private String cpf;

    @NotNull
    @Min(value = 3)
    private String firstName;

    @NotNull
    @Min(value = 3)
    private String lastName;

    @NotNull
    private Sex sex;

    @NotNull
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate birthdate;

    @NotNull
    @Email
    private String email;

    @NotNull
    @Min(value = 6)
    private String password;

    @NotNull
    private Boolean active;
}

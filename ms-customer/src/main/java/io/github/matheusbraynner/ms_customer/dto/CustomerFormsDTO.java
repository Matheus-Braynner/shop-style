package io.github.matheusbraynner.ms_customer.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.github.matheusbraynner.ms_customer.entities.enums.Sex;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.LowerCamelCaseStrategy.class)
public class CustomerFormsDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 5490378330342920212L;

    @CPF
    @NotNull
    private String cpf;

    @NotNull
    @Length(min = 3, message = "must be greater than or equal to 3")
    private String firstName;

    @NotNull
    @Length(min = 3, message = "must be greater than or equal to 3")
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
    @Length(min = 6, message = "must be greater than or equal to 6")
    private String password;

    @NotNull
    private Boolean active;
}

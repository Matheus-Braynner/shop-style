package io.github.matheusbraynner.ms_customer.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.io.Serial;
import java.io.Serializable;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.LowerCamelCaseStrategy.class)
public class LoginFormsDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 6312606030688437844L;

    @NotNull
    @Email
    private String email;

    @NotNull
    @Length(min = 6, message = "must be greater than or equal to 6")
    private String password;

}

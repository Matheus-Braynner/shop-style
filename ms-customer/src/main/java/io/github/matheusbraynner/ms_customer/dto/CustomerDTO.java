package io.github.matheusbraynner.ms_customer.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
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
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.LowerCamelCaseStrategy.class)
public class CustomerDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 6427951113210246897L;

    private String firstName;

    private String lastName;

    private Sex sex;

    private LocalDate birthDate;

    private String email;

    private Boolean active;
}

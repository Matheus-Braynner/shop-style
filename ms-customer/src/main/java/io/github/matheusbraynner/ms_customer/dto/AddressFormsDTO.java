package io.github.matheusbraynner.ms_customer.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.github.matheusbraynner.ms_customer.entities.enums.States;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.LowerCamelCaseStrategy.class)
public class AddressFormsDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = -6303958682114286128L;

    @NotNull
    private States state;

    @NotNull
    private String city;

    @NotNull
    private String district;

    @NotNull
    private String street;

    @NotNull
    private String number;

    @NotNull
    private String cep;

    private String complement;

    @NotNull
    private Long customerId;
}

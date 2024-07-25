package io.github.matheusbraynner.ms_customer.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.github.matheusbraynner.ms_customer.entities.enums.States;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.LowerCamelCaseStrategy.class)
public class AddressDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 5683249760773571403L;

    private Long id;

    private States state;

    private String city;

    private String district;

    private String street;

    private String number;

    private String cep;

    private String complement;

    private Long customerId;
}

package io.github.matheusbraynner.ms_customer.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.github.matheusbraynner.ms_customer.entities.Address;
import io.github.matheusbraynner.ms_customer.entities.enums.Sex;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

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

    private Long id;

    private String firstName;

    private String lastName;

    private Sex sex;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate birthdate;

    private String email;

    private Boolean active;

    private List<Address> addresses;
}

package io.github.matheusbraynner.mscatalog.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.LowerCamelCaseStrategy.class)
public class ProductFormsDTO implements Serializable {

    @NotNull
    private String name;

    @NotNull
    private String description;

    @NotNull
    private String brand;

    @NotNull
    private String material;

    @NotNull
    private Boolean active;

    @NotNull
    private Long category;

}

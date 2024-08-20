package io.github.matheusbraynner.mscatalog.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.github.matheusbraynner.mscatalog.entities.Media;
import io.github.matheusbraynner.mscatalog.entities.Product;
import io.github.matheusbraynner.mscatalog.entities.enums.Size;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.LowerCamelCaseStrategy.class)
public class SkuFormsDTO {

    @NotNull
    private BigDecimal price;

    @NotNull
    private Integer quantity;

    @NotNull
    private String color;

    @NotNull
    private Size size;

    @NotNull
    private Integer height;

    @NotNull
    private Integer width;

    @NotNull
    private Product product;

    @NotNull
    private List<Media> medias;
}

package io.github.matheusbraynner.mscatalog.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.matheusbraynner.mscatalog.entities.Media;
import io.github.matheusbraynner.mscatalog.entities.Product;
import io.github.matheusbraynner.mscatalog.entities.enums.Size;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SkuDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = -6725327717785990209L;

    private Long id;

    private BigDecimal price;

    private Integer quantity;

    private String color;

    private Size size;

    private Integer height;

    private Integer width;

    private Product product;

    private List<MediaDTO> medias;
}

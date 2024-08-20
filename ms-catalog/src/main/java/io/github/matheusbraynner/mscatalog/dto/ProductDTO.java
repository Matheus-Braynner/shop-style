package io.github.matheusbraynner.mscatalog.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.github.matheusbraynner.mscatalog.entities.Category;
import io.github.matheusbraynner.mscatalog.entities.Sku;
import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = -2611748953148883370L;

    private Long id;

    private String name;

    private String description;

    private String brand;

    private String material;

    private Boolean active;

    private List<Sku> skus;

    private Category category;
}

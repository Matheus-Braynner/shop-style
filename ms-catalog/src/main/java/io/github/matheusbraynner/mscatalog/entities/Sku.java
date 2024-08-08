package io.github.matheusbraynner.mscatalog.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.github.matheusbraynner.mscatalog.entities.enums.Size;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@EqualsAndHashCode
@Table(name = "tb_skus")
public class Sku {


    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "color")
    private String color;

    @Column(name = "size")
    private Size size;

    @Column(name = "height")
    private Integer height;

    @Column(name = "width")
    private Integer width;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    private Product product;
}

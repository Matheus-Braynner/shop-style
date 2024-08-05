package io.github.matheusbraynner.mscatalog.mappers;

import io.github.matheusbraynner.mscatalog.dto.ProductDTO;
import io.github.matheusbraynner.mscatalog.dto.ProductFormsDTO;
import io.github.matheusbraynner.mscatalog.entities.Product;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    Product toProduct(ProductFormsDTO productFormsDTO);

    List<ProductDTO> toProductListDTO(List<Product> products);

    ProductDTO toProductDTO(Product product);
}

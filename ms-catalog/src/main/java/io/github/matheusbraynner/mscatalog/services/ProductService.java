package io.github.matheusbraynner.mscatalog.services;

import io.github.matheusbraynner.mscatalog.dto.ProductDTO;
import io.github.matheusbraynner.mscatalog.dto.ProductFormsDTO;

import java.util.List;

public interface ProductService {

    ProductDTO insertProduct(ProductFormsDTO productFormsDTO);

    List<ProductDTO> findProducts();

    ProductDTO findProductsById(Long id);

    ProductDTO updateProduct(Long id, ProductFormsDTO productFormsDTO);

    void deleteProduct(Long id);
}

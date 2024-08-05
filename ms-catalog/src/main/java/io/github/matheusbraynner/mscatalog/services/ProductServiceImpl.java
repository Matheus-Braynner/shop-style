package io.github.matheusbraynner.mscatalog.services;

import io.github.matheusbraynner.mscatalog.dto.ProductDTO;
import io.github.matheusbraynner.mscatalog.dto.ProductFormsDTO;
import io.github.matheusbraynner.mscatalog.entities.Product;
import io.github.matheusbraynner.mscatalog.mappers.ProductMapper;
import io.github.matheusbraynner.mscatalog.repositories.ProductRepository;
import io.github.matheusbraynner.mscatalog.services.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    private final ProductMapper productMapper;

    @Override
    public ProductDTO insertProduct(ProductFormsDTO productFormsDTO) {
        
        Product product = productMapper.toProduct(productFormsDTO);

        Product productSaved = productRepository.save(product);

        return productMapper.toProductDTO(productSaved);
    }

    @Override
    public List<ProductDTO> findProducts() {

        List<Product> productList = productRepository.findAll();
        
        return productMapper.toProductListDTO(productList);
    }

    @Override
    public ProductDTO findProductsById(Long id) {

        Product productFound = getProduct(id);

        return productMapper.toProductDTO(productFound);
    }

    @Override
    public ProductDTO updateProduct(Long id, ProductFormsDTO productFormsDTO) {
        
        Product productFound = getProduct(id);

        updatedProduct(productFormsDTO, productFound);
        Product productUpdated = productRepository.save(productFound);

        return productMapper.toProductDTO(productUpdated);
    }

    @Override
    public void deleteProduct(Long id) {
        
        Product productFound = getProduct(id);

        productRepository.delete(productFound);
    }

    private static void updatedProduct(ProductFormsDTO productFormsDTO, Product productFound) {
        productFound.setName(productFormsDTO.getName());
        productFound.setDescription(productFormsDTO.getDescription());
        productFound.setBrand(productFormsDTO.getBrand());
        productFound.setMaterial(productFormsDTO.getMaterial());
        productFound.setActive(productFormsDTO.getActive());
    }

    private Product getProduct(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product with id: " + id + " was not found"));
    }
}

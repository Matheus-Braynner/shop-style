package io.github.matheusbraynner.mscatalog.controllers;

import io.github.matheusbraynner.mscatalog.dto.ProductDTO;
import io.github.matheusbraynner.mscatalog.dto.ProductFormsDTO;
import io.github.matheusbraynner.mscatalog.services.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RequestMapping(value = "/v1/products")
@RestControllerAdvice
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<ProductDTO> insertProduct(@Valid @RequestBody ProductFormsDTO productFormsDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.insertProduct(productFormsDTO));
    }

    @GetMapping
    public ResponseEntity<List<ProductDTO>> findAllProducts() {
        return ResponseEntity.status(HttpStatus.OK).body(productService.findProducts());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ProductDTO> findProductById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(productService.findProductsById(id));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ProductDTO> updateProduct(@PathVariable Long id, @Valid @RequestBody ProductFormsDTO productFormsDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(productService.updateProduct(id, productFormsDTO));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}

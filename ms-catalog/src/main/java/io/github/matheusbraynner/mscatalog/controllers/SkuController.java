package io.github.matheusbraynner.mscatalog.controllers;

import io.github.matheusbraynner.mscatalog.dto.SkuDTO;
import io.github.matheusbraynner.mscatalog.dto.SkuFormsDTO;
import io.github.matheusbraynner.mscatalog.services.SkuService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/v1/skus")
@RestController
@RequiredArgsConstructor
public class SkuController {

    private final SkuService skuService;

    @PostMapping
    public ResponseEntity<SkuDTO> insertSku(@Valid @RequestBody SkuFormsDTO skuFormsDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(skuService.insertSku(skuFormsDTO));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<SkuDTO> updateSku(@PathVariable Long id, @Valid @RequestBody SkuFormsDTO skuFormsDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(skuService.updateSku(id, skuFormsDTO));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteSku(@PathVariable Long id) {
        skuService.deleteSku(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}

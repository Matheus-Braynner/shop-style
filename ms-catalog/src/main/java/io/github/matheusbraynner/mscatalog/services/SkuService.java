package io.github.matheusbraynner.mscatalog.services;

import io.github.matheusbraynner.mscatalog.dto.SkuDTO;
import io.github.matheusbraynner.mscatalog.dto.SkuFormsDTO;

public interface SkuService {

    SkuDTO insertSku(SkuFormsDTO skuFormsDTO);

    SkuDTO updateSku(Long id, SkuFormsDTO skuFormsDTO);

    void deleteSku(Long id);
}

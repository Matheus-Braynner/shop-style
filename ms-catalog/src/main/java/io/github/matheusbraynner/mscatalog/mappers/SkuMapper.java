package io.github.matheusbraynner.mscatalog.mappers;

import io.github.matheusbraynner.mscatalog.dto.SkuDTO;
import io.github.matheusbraynner.mscatalog.dto.SkuFormsDTO;
import io.github.matheusbraynner.mscatalog.entities.Sku;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SkuMapper {

    Sku toSku(SkuFormsDTO skuFormsDTO);

    SkuDTO toSkuDTO(Sku sku);
}

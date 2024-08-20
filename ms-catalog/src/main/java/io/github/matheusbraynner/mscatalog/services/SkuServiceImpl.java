package io.github.matheusbraynner.mscatalog.services;

import io.github.matheusbraynner.mscatalog.dto.SkuDTO;
import io.github.matheusbraynner.mscatalog.dto.SkuFormsDTO;
import io.github.matheusbraynner.mscatalog.entities.Media;
import io.github.matheusbraynner.mscatalog.entities.Product;
import io.github.matheusbraynner.mscatalog.entities.Sku;
import io.github.matheusbraynner.mscatalog.mappers.SkuMapper;
import io.github.matheusbraynner.mscatalog.repositories.MediaRepository;
import io.github.matheusbraynner.mscatalog.repositories.ProductRepository;
import io.github.matheusbraynner.mscatalog.repositories.SkuRepository;
import io.github.matheusbraynner.mscatalog.services.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SkuServiceImpl implements SkuService {

    private final SkuMapper skuMapper;

    private final SkuRepository skuRepository;

    private final ProductRepository productRepository;

    private final MediaRepository mediaRepository;

    @Override
    public SkuDTO insertSku(SkuFormsDTO skuFormsDTO) {
        Product product = findProduct(skuFormsDTO);

        Sku sku = skuMapper.toSku(skuFormsDTO);
        sku.setProduct(product);

        saveMedias(sku);

        Sku skuSaved = skuRepository.save(sku);

        return skuMapper.toSkuDTO(skuSaved);
    }



    @Override
    public SkuDTO updateSku(Long id, SkuFormsDTO skuFormsDTO) {
        Sku sku = skuRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Sku with id: " + id + " was not found"));
        Product product = findProduct(skuFormsDTO);

        updatedSku(skuFormsDTO, sku, product);
        saveMedias(sku);

        Sku skuSaved = skuRepository.save(sku);

        return skuMapper.toSkuDTO(skuSaved);
    }


    @Override
    public void deleteSku(Long id) {
        Sku sku = skuRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Sku with id: " + id + " was not found"));

        skuRepository.delete(sku);
    }

    private Product findProduct(SkuFormsDTO skuFormsDTO) {
        return productRepository.findById(skuFormsDTO.getProduct().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Product was not found"));
    }

    private static void updatedSku(SkuFormsDTO skuFormsDTO, Sku sku, Product product) {
        sku.setPrice(skuFormsDTO.getPrice());
        sku.setQuantity(skuFormsDTO.getQuantity());
        sku.setColor(skuFormsDTO.getColor());
        sku.setSize(skuFormsDTO.getSize());
        sku.setHeight(skuFormsDTO.getHeight());
        sku.setWidth(skuFormsDTO.getWidth());
        sku.setProduct(product);
        sku.setMedias(skuFormsDTO.getMedias());
    }

    private void saveMedias(Sku sku) {
        for (Media m : sku.getMedias()) {
            mediaRepository.save(m);
        }
    }
}

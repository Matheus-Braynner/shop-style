package io.github.matheusbraynner.mscatalog.repositories;

import io.github.matheusbraynner.mscatalog.entities.Sku;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkuRepository extends JpaRepository<Sku, Long> {
}

package io.github.matheusbraynner.mscatalog.repositories;

import io.github.matheusbraynner.mscatalog.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}

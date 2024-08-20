package io.github.matheusbraynner.mscatalog.repositories;

import io.github.matheusbraynner.mscatalog.entities.Media;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MediaRepository extends JpaRepository<Media, Long> {
}

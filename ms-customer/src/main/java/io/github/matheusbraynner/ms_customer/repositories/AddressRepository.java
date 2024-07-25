package io.github.matheusbraynner.ms_customer.repositories;

import io.github.matheusbraynner.ms_customer.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}

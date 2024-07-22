package io.github.matheusbraynner.ms_customer.mappers;

import io.github.matheusbraynner.ms_customer.dto.CustomerDTO;
import io.github.matheusbraynner.ms_customer.dto.CustomerFormsDTO;
import io.github.matheusbraynner.ms_customer.entities.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    Customer toCustomer(CustomerFormsDTO customerFormsDTO);

    CustomerDTO toCustomerDTO(Customer customer);
}

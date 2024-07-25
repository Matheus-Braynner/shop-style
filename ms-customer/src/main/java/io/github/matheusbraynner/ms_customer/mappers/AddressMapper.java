package io.github.matheusbraynner.ms_customer.mappers;

import io.github.matheusbraynner.ms_customer.dto.AddressDTO;
import io.github.matheusbraynner.ms_customer.dto.AddressFormsDTO;
import io.github.matheusbraynner.ms_customer.entities.Address;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AddressMapper {

    Address toAddress(AddressFormsDTO addressFormsDTO);

    @Mapping(target = "customerId", source = "address.id")
    AddressDTO toAddressDTO(Address address);
}

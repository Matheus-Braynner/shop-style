package io.github.matheusbraynner.ms_customer.services;

import io.github.matheusbraynner.ms_customer.dto.AddressDTO;
import io.github.matheusbraynner.ms_customer.dto.AddressFormsDTO;

public interface AddressService {

    AddressDTO insertAddress(AddressFormsDTO addressFormsDTO);

    AddressDTO updateAddress(Long id, AddressFormsDTO addressFormsDTO);

    AddressDTO findAddressById(Long id);

    void deleteAddress(Long id);
}

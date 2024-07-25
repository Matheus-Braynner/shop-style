package io.github.matheusbraynner.ms_customer.services;

import io.github.matheusbraynner.ms_customer.dto.AddressDTO;
import io.github.matheusbraynner.ms_customer.dto.AddressFormsDTO;
import io.github.matheusbraynner.ms_customer.entities.Address;
import io.github.matheusbraynner.ms_customer.entities.Customer;
import io.github.matheusbraynner.ms_customer.mappers.AddressMapper;
import io.github.matheusbraynner.ms_customer.repositories.AddressRepository;
import io.github.matheusbraynner.ms_customer.repositories.CustomerRepository;
import io.github.matheusbraynner.ms_customer.services.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;

    private final CustomerRepository customerRepository;

    private final AddressMapper addressMapper;

    @Override
    public AddressDTO insertAddress(AddressFormsDTO addressFormsDTO) {
        Customer customer = findCustomerById(addressFormsDTO.getCustomerId());

        Address address = addressMapper.toAddress(addressFormsDTO);
        address.setCustomer(customer);

        Address addressSaved = addressRepository.save(address);

        return addressMapper.toAddressDTO(addressSaved);
    }

    @Override
    public AddressDTO updateAddress(Long id, AddressFormsDTO addressFormsDTO) {
        Address address = findAddressById(id);
        Customer findCustomerFromForms = findCustomerById(addressFormsDTO.getCustomerId());

        updateAddress(addressFormsDTO, address, findCustomerFromForms);

        Address addressSaved = addressRepository.save(address);

        return addressMapper.toAddressDTO(addressSaved);
    }


    @Override
    public void deleteAddress(Long id) {
        Address address = findAddressById(id);

        addressRepository.delete(address);
    }

    private static void updateAddress(AddressFormsDTO addressFormsDTO, Address address, Customer findCustomerFromForms) {
        address.setState(addressFormsDTO.getState());
        address.setCity(addressFormsDTO.getCity());
        address.setDistrict(addressFormsDTO.getDistrict());
        address.setStreet(addressFormsDTO.getStreet());
        address.setNumber(addressFormsDTO.getNumber());
        address.setCep(addressFormsDTO.getCep());
        address.setComplement(addressFormsDTO.getComplement());
        address.setCustomer(findCustomerFromForms);
    }

    private Address findAddressById(Long id) {
        return addressRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Address with id: " + id + " was not found"));
    }

    private Customer findCustomerById(Long id) {
        return customerRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Customer with id: " + id + " was not found"));
    }
}

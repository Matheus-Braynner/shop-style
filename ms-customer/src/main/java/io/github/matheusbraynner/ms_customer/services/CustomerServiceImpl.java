package io.github.matheusbraynner.ms_customer.services;

import io.github.matheusbraynner.ms_customer.dto.ChangePasswordFormsDTO;
import io.github.matheusbraynner.ms_customer.dto.CustomerDTO;
import io.github.matheusbraynner.ms_customer.dto.CustomerFormsDTO;
import io.github.matheusbraynner.ms_customer.entities.Customer;
import io.github.matheusbraynner.ms_customer.mappers.CustomerMapper;
import io.github.matheusbraynner.ms_customer.repositories.CustomerRepository;
import io.github.matheusbraynner.ms_customer.services.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    private final CustomerMapper customerMapper;

    @Override
    public CustomerDTO insertCustomer(CustomerFormsDTO customerFormsDTO) {

        Customer customer = customerMapper.toCustomer(customerFormsDTO);
        Customer customerSaved = customerRepository.save(customer);

        return customerMapper.toCustomerDTO(customerSaved);
    }

    @Override
    public CustomerDTO findCustomerById(Long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer with " + id + " not found."));

        return customerMapper.toCustomerDTO(customer);
    }

    @Override
    public CustomerDTO updateCustomer(Long id, CustomerFormsDTO customerFormsDTO) {
       Customer customerFound = findCustomerToUpdate(id);

       customerFound.setFirstName(customerFormsDTO.getFirstName());
       customerFound.setLastName(customerFormsDTO.getLastName());
       customerFound.setCpf(customerFormsDTO.getCpf());
       customerFound.setBirthdate(customerFormsDTO.getBirthdate());
       customerFound.setSex(customerFormsDTO.getSex());
       customerFound.setEmail(customerFormsDTO.getEmail());
       customerFound.setPassword(customerFormsDTO.getPassword());
       customerFound.setActive(customerFormsDTO.getActive());
       Customer customerUpdated = customerRepository.save(customerFound);

        return customerMapper.toCustomerDTO(customerUpdated);
    }

    @Override
    public void updateCustomerPassword(Long id, ChangePasswordFormsDTO changePasswordFormsDTO) {
        Customer customerFound = findCustomerToUpdate(id);

        customerFound.setPassword(changePasswordFormsDTO.getPassword());
        customerRepository.save(customerFound);
    }

    private Customer findCustomerToUpdate(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer with " + id + " not found."));
    }
}

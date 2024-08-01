package io.github.matheusbraynner.ms_customer.services;

import io.github.matheusbraynner.ms_customer.dto.ChangePasswordFormsDTO;
import io.github.matheusbraynner.ms_customer.dto.CustomerDTO;
import io.github.matheusbraynner.ms_customer.dto.CustomerFormsDTO;
import io.github.matheusbraynner.ms_customer.dto.LoginFormsDTO;
import io.github.matheusbraynner.ms_customer.entities.Customer;
import io.github.matheusbraynner.ms_customer.mappers.CustomerMapper;
import io.github.matheusbraynner.ms_customer.repositories.CustomerRepository;
import io.github.matheusbraynner.ms_customer.services.exceptions.InvalidLoginException;
import io.github.matheusbraynner.ms_customer.services.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    private final CustomerMapper customerMapper;

    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public CustomerDTO insertCustomer(CustomerFormsDTO customerFormsDTO) {

        Customer customer = customerMapper.toCustomer(customerFormsDTO);
        passwordEncoder(customer);
        Customer customerSaved = customerRepository.save(customer);

        return customerMapper.toCustomerDTO(customerSaved);
    }

    @Override
    public CustomerDTO findCustomerById(Long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer with id: " + id + " was not found."));

        return customerMapper.toCustomerDTO(customer);
    }

    @Override
    public CustomerDTO updateCustomer(Long id, CustomerFormsDTO customerFormsDTO) {
       Customer customerFound = findCustomerToUpdate(id);

        updateCustomer(customerFormsDTO, customerFound);
        passwordEncoder(customerFound);
        Customer customerUpdated = customerRepository.save(customerFound);

        return customerMapper.toCustomerDTO(customerUpdated);
    }

    @Override
    public void updateCustomerPassword(Long id, ChangePasswordFormsDTO changePasswordFormsDTO) {
        Customer customerFound = findCustomerToUpdate(id);

        customerFound.setPassword(changePasswordFormsDTO.getPassword());
        passwordEncoder(customerFound);
        customerRepository.save(customerFound);
    }

    @Override
    public CustomerDTO login(LoginFormsDTO loginFormsDTO) {
        Customer customer = customerRepository.findByEmail(loginFormsDTO.getEmail())
                .orElseThrow(()-> new InvalidLoginException("Error to login, please check if the fields are correctly"));

        if (!passwordEncoder.matches(loginFormsDTO.getPassword(), customer.getPassword())) {
            throw new InvalidLoginException("Error to login, please check if the fields are correctly");
        }

        return customerMapper.toCustomerDTO(customer);
    }

    private void passwordEncoder(Customer customer) {
        customer.setPassword(passwordEncoder.encode(customer.getPassword()));
    }


    private static void updateCustomer(CustomerFormsDTO customerFormsDTO, Customer customerFound) {
        customerFound.setFirstName(customerFormsDTO.getFirstName());
        customerFound.setLastName(customerFormsDTO.getLastName());
        customerFound.setCpf(customerFormsDTO.getCpf());
        customerFound.setBirthdate(customerFormsDTO.getBirthdate());
        customerFound.setSex(customerFormsDTO.getSex());
        customerFound.setEmail(customerFormsDTO.getEmail());
        customerFound.setPassword(customerFormsDTO.getPassword());
        customerFound.setActive(customerFormsDTO.getActive());
    }

    private Customer findCustomerToUpdate(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer with id: " + id + " was not found."));
    }
}

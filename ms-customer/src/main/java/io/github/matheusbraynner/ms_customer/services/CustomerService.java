package io.github.matheusbraynner.ms_customer.services;

import io.github.matheusbraynner.ms_customer.dto.ChangePasswordFormsDTO;
import io.github.matheusbraynner.ms_customer.dto.CustomerDTO;
import io.github.matheusbraynner.ms_customer.dto.CustomerFormsDTO;

public interface CustomerService {

    CustomerDTO insertCustomer(CustomerFormsDTO customerFormsDTO);

    CustomerDTO findCustomerById(Long id);

    CustomerDTO updateCustomer(Long id, CustomerFormsDTO customerFormsDTO);

    CustomerDTO updateCustomerPassword(Long id, ChangePasswordFormsDTO changePasswordFormsDTO);
}

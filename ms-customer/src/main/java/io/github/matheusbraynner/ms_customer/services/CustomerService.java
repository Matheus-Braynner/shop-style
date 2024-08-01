package io.github.matheusbraynner.ms_customer.services;

import io.github.matheusbraynner.ms_customer.dto.ChangePasswordFormsDTO;
import io.github.matheusbraynner.ms_customer.dto.CustomerDTO;
import io.github.matheusbraynner.ms_customer.dto.CustomerFormsDTO;
import io.github.matheusbraynner.ms_customer.dto.LoginFormsDTO;

public interface CustomerService {

    CustomerDTO insertCustomer(CustomerFormsDTO customerFormsDTO);

    CustomerDTO findCustomerById(Long id);

    CustomerDTO updateCustomer(Long id, CustomerFormsDTO customerFormsDTO);

    void updateCustomerPassword(Long id, ChangePasswordFormsDTO changePasswordFormsDTO);

    CustomerDTO login(LoginFormsDTO loginFormsDTO);
}

package io.github.matheusbraynner.ms_customer.controllers;

import io.github.matheusbraynner.ms_customer.dto.ChangePasswordFormsDTO;
import io.github.matheusbraynner.ms_customer.dto.CustomerDTO;
import io.github.matheusbraynner.ms_customer.dto.CustomerFormsDTO;
import io.github.matheusbraynner.ms_customer.services.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/v1/customers")
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity<CustomerDTO> insertCustomer(@Valid @RequestBody CustomerFormsDTO customerFormsDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(customerService.insertCustomer(customerFormsDTO));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CustomerDTO> findCustomerById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(customerService.findCustomerById(id));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<CustomerDTO> updateCustomer(@PathVariable Long id, @Valid @RequestBody CustomerFormsDTO customerFormsDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(customerService.updateCustomer(id, customerFormsDTO));
    }

    @PutMapping(value = "/{id}/password")
    public ResponseEntity<Void> changePassword(@PathVariable Long id, @Valid @RequestBody ChangePasswordFormsDTO changePasswordFormsDTO) {
        customerService.updateCustomerPassword(id, changePasswordFormsDTO);
        return ResponseEntity.status(HttpStatus.OK).build();
    }


}

package io.github.matheusbraynner.ms_customer.controllers;

import io.github.matheusbraynner.ms_customer.dto.CustomerDTO;
import io.github.matheusbraynner.ms_customer.dto.LoginFormsDTO;
import io.github.matheusbraynner.ms_customer.services.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/v1/login")
public class LoginController {

    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity<CustomerDTO> login(@Valid @RequestBody LoginFormsDTO loginFormsDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(customerService.login(loginFormsDTO));
    }
}

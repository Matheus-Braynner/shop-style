package io.github.matheusbraynner.ms_customer.controllers;

import io.github.matheusbraynner.ms_customer.dto.AddressDTO;
import io.github.matheusbraynner.ms_customer.dto.AddressFormsDTO;
import io.github.matheusbraynner.ms_customer.services.AddressService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/v1/addresses")
public class AddressController {

    private final AddressService addressService;

    @PostMapping
    public ResponseEntity<AddressDTO> insertAddress(@Valid @RequestBody AddressFormsDTO addressFormsDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(addressService.insertAddress(addressFormsDTO));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<AddressDTO> findAddressById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(addressService.findAddressById(id));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<AddressDTO> updateAddress(@PathVariable Long id, @Valid @RequestBody AddressFormsDTO addressFormsDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(addressService.updateAddress(id, addressFormsDTO));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteAddress(@PathVariable Long id) {
        addressService.deleteAddress(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}

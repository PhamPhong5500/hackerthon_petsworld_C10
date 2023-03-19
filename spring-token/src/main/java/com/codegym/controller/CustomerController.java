package com.codegym.controller;

import com.codegym.dto.CustomerDto;
import com.codegym.dto.PartnerDto;
import com.codegym.entity.Customer;
import com.codegym.entity.Partner;
import com.codegym.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping("/customers")
    public ResponseEntity<Iterable<CustomerDto>> getCustomers() {
        return ResponseEntity.ok().body(customerService.getCustomers());
    }

    @PostMapping("/customer/save")
    public ResponseEntity<CustomerDto> saveCustomer(@RequestBody CustomerDto customerDto) {
        return ResponseEntity.created(null).body(customerService.saveCustomer(customerDto));
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<CustomerDto> getCustomer(@PathVariable Long id) {
        CustomerDto customer = customerService.getCustomer(id);
        if (customer == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(customer);
    }

    @PutMapping("/customer/{id}")
    public ResponseEntity<CustomerDto> updateCustomer(@PathVariable Long id, @RequestBody Customer customer) {
        CustomerDto existingCustomer = customerService.getCustomer(id);
        if (existingCustomer == null) {
            return ResponseEntity.notFound().build();
        }
        customer.setId(id);
        customer.setFirstName(customer.getFirstName());
        return ResponseEntity.ok().body(existingCustomer);
    }

    @DeleteMapping("/customer/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
        CustomerDto existingCustomer = customerService.getCustomer(id);
        if (existingCustomer == null) {
            return ResponseEntity.notFound().build();
        } else {
            existingCustomer.setStatus(false);
            customerService.saveCustomer(existingCustomer);
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<List<PartnerDto>> searchAddress(@PathVariable Long id) {
        return ResponseEntity.ok().body(customerService.searchPartnerByAddress(id));
    }
}


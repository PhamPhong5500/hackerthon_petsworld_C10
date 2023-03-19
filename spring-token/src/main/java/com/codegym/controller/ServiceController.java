package com.codegym.controller;

import com.codegym.dto.CustomerDto;
import com.codegym.entity.Service;
import com.codegym.service.IServiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ServiceController {
    private final IServiceService serviceService;
    @GetMapping("/services")
    public ResponseEntity<Iterable<Service>> getCustomers() {
        return ResponseEntity.ok().body(serviceService.getServices());
    }
}

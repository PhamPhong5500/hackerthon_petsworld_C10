package com.codegym.controller;

import com.codegym.dto.ProductDto;
import com.codegym.entity.Product;
import com.codegym.repository.IProductRepository;
import com.codegym.service.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ProductController {
    private final IProductService productService;
    @GetMapping("/products")
    public ResponseEntity<List<ProductDto>> getProducts(){
        return ResponseEntity.ok().body(productService.getProducts());
    }
}

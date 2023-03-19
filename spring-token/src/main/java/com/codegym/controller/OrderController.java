package com.codegym.controller;

import com.codegym.entity.Order;
import com.codegym.service.IOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class OrderController {
    private final IOrderService orderService;
    @GetMapping("/orders")
    public ResponseEntity<List<Order>> getOrders(){
        return ResponseEntity.ok().body(orderService.getOrders());
    }
}

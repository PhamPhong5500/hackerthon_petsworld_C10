package com.codegym.service;

import com.codegym.entity.Order;
import com.codegym.repository.IOrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class OrderService implements IOrderService{
    private final IOrderRepository orderRepository;
    @Override
    public List<Order> getOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order saveOrder(Order order) {
        return null;
    }

    @Override
    public void deleteOrder(Long id) {

    }

    @Override
    public Order getOrder(Long id) {
        return null;
    }
}

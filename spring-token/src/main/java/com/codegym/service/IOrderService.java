package com.codegym.service;

import com.codegym.dto.CustomerDto;
import com.codegym.entity.Order;

import java.util.List;

public interface IOrderService {
    List<Order> getOrders();
    Order saveOrder(Order order);
    void deleteOrder(Long id);
    Order getOrder(Long id);
}

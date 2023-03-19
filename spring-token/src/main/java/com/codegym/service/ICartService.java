package com.codegym.service;

import com.codegym.dto.CustomerDto;
import com.codegym.entity.Cart;

import java.util.List;

public interface ICartService {

    List<Cart> getCarts();
    Cart saveCart(Cart cart);
    void deleteCart(Long id);
    Cart getCart(Long id);
    Cart addProductToCart(Long cartId, Long productId);
}

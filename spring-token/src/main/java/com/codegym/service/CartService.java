package com.codegym.service;

import com.codegym.entity.Cart;
import com.codegym.entity.Product;
import com.codegym.repository.ICartRepository;
import com.codegym.repository.IProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service @RequiredArgsConstructor
public class CartService implements ICartService{
    private final IProductRepository productRepository;

    private final ICartRepository cartRepository;
    @Override
    public List<Cart> getCarts() {
        return cartRepository.findAll();
    }

    @Override
    public Cart saveCart(Cart cart) {
        return cartRepository.save(cart);
    }

    @Override
    public void deleteCart(Long id) {
        cartRepository.deleteById(id);
    }

    @Override
    public Cart getCart(Long id) {
        return cartRepository.findById(id).get();
    }
    public Cart addProductToCart(Long cartId, Long productId){
       Product product=  productRepository.findById(productId).get();
       Cart cart = getCart(cartId);
       cart.getProducts().add(product);
       cartRepository.save(cart);
       return getCart(cartId);
    }
}

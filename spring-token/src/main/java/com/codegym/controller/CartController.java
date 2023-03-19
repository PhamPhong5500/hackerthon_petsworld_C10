package com.codegym.controller;

import com.codegym.dto.CartProduct;
import com.codegym.dto.CustomerDto;
import com.codegym.entity.Cart;
import com.codegym.service.ICartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class CartController {
    private final ICartService cartService;
    @GetMapping("/carts")
    public ResponseEntity<List<Cart>> getCarts() {
        return ResponseEntity.ok().body(cartService.getCarts());
    }
    @GetMapping("/cart/{id}")
    public ResponseEntity<Cart> getCart(@PathVariable Long id) {
        Cart cart = cartService.getCart(id);
        if (cart == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(cart);
    }
    @PostMapping("/card/addproducttocart/{id}")
    public ResponseEntity<?> addProductToCard(@PathVariable Long id){
        return ResponseEntity.created(null).body(cartService.addProductToCart(1L,
                id));
    }
}


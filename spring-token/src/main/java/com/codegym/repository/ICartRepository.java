package com.codegym.repository;

import com.codegym.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICartRepository extends JpaRepository<Cart, Long> {
}

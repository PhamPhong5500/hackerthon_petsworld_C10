package com.codegym.repository;

import com.codegym.entity.Cart;
import com.codegym.entity.Product;
import com.codegym.entity.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<Product, Long> {
    Product findProductByName(String name);
}

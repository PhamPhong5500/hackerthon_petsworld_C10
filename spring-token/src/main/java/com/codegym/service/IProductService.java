package com.codegym.service;

import com.codegym.dto.ProductDto;
import com.codegym.entity.Product;

import java.util.List;

public interface IProductService {
    List<ProductDto> getProducts();
    Product getProduct(Long id);
    void deleteProduct(Long id);

    Product saveProduct(Product product);

}

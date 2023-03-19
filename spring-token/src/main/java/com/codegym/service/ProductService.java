package com.codegym.service;

import com.codegym.dto.ProductDto;
import com.codegym.entity.Product;
import com.codegym.repository.IProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service @RequiredArgsConstructor
public class ProductService implements IProductService {
    private final IProductRepository productRepository;
    @Override
    public List<ProductDto> getProducts() {
        List<ProductDto> productDtoList = new ArrayList<>();
        List<Product> products = this.productRepository.findAll();
        products.forEach(product -> productDtoList.add(new ProductDto(product.getId(), product.getName(),
                product.getImage(), product.getPrice(), product.getStatus(), product.getQuantity(),
                (product.getPrice() * product.getStatus() / 100))));
        return productDtoList;
    }
    private Double price;
    private  Double status;
    private Double quantity;
    @Override
    public Product getProduct(Long id) {
        return productRepository.findById(id).get();
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }
    public Product findProductByName(String name){
      return   this.productRepository.findProductByName(name);
    }
}

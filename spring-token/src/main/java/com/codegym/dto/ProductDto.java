package com.codegym.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data @NoArgsConstructor @AllArgsConstructor
public class ProductDto {

    private  Long id;
    private  String name;
    private String image;
    private Double unitPrice;
    private  Double discount;

    private Double quantity;


    private Double subtotal;


}

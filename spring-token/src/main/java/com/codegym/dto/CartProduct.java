package com.codegym.dto;

import com.codegym.entity.Cart;
import com.codegym.entity.Product;
import lombok.Data;

import javax.persistence.*;

 @Data
public class CartProduct {
    private  Long cardId;

    private Long productId;
}

package com.codegym.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity @AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date time;
    @ManyToOne(targetEntity = Partner.class)
    @JoinColumn(name = "partner_id", referencedColumnName = "id")
    private Partner partners;
    @ManyToOne(targetEntity = Customer.class)
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customers;
    @ManyToOne(targetEntity = OrderService.class)
    @JoinColumn(name = "service_id", referencedColumnName = "id")
    private OrderService orderService;

//    @ManyToOne(targetEntity = Cart.class)
//    @JoinColumn(name = "cart_id", referencedColumnName = "id"))
//    private Cart cart;

    private Long total;

}

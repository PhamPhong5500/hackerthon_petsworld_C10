package com.codegym.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "order_service")
public class OrderService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(targetEntity = Order.class)
    private List<Order> orders;
    @OneToMany(targetEntity = Service.class)
    private List<Service> services;

}

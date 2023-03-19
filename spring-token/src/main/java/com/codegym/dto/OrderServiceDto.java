package com.codegym.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "order_service")
public class OrderServiceDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(targetEntity = OrderDto.class)
    private List<OrderDto> orders;
    @OneToMany(targetEntity = ServiceDto.class)
    private List<ServiceDto> services;

}

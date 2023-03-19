package com.codegym.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Entity @AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "orders")
public class OrderDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int total;
    private Date time;
    @ManyToOne(targetEntity = PartnerDto.class)
    @JoinColumn(name = "partner_id", referencedColumnName = "id")
    private PartnerDto partners;
    @ManyToOne(targetEntity = CustomerDto.class)
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private CustomerDto customers;
    @ManyToOne(targetEntity = OrderServiceDto.class)
    @JoinColumn(name = "oder_service_id", referencedColumnName = "id")
    private OrderServiceDto orderService;


}

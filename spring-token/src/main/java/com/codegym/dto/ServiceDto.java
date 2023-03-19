package com.codegym.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity @AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="services")
public class ServiceDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Date bookingTime;
    private int duration;
    private Long price;


//    @JoinColumn(name = "partner_service_id")
//    private PartnerService partnerService;
//    @ManyToOne(targetEntity = OrderService.class)
//    @JoinColumn(name = "oder_service_id", referencedColumnName = "id")
//    private OrderService orderService;

}

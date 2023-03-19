package com.codegym.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity @AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="services")
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Date bookingTime;
    private int duration;
    private Long price;


//    @ManyToOne(targetEntity = PartnerService.class)
//    @JoinColumn(name = "partner_service_id")
//    private PartnerService partnerService;
//    @ManyToOne(targetEntity = OrderService.class)
//    @JoinColumn(name = "oder_service_id", referencedColumnName = "id")
//    private OrderService orderService;

}

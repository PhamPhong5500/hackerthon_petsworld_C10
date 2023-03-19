package com.codegym.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity @AllArgsConstructor
@NoArgsConstructor
@Data
@Table (name = "partner_service")
public class PartnerService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(targetEntity = Partner.class)
    @JoinColumn(name = "partner_id")
    private List<Partner> partners;
    @OneToMany(targetEntity = Service.class)
    @JoinColumn(name = "service_id")
    private List<Service> services;
}

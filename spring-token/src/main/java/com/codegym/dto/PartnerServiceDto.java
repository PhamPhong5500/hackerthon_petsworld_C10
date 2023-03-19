package com.codegym.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity @AllArgsConstructor
@NoArgsConstructor
@Data
@Table (name = "partner_service")
public class PartnerServiceDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(targetEntity = PartnerDto.class)
    @JoinColumn(name = "partner_id")
    private List<PartnerDto> partners;
    @OneToMany(targetEntity = ServiceDto.class)
    @JoinColumn(name = "service_id")
    private List<ServiceDto> services;
}

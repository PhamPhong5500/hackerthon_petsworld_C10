package com.codegym.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "pets")
public class PetDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Boolean gender;
    private Date birth;
    @ManyToOne(targetEntity = CustomerDto.class)
    @JoinColumn(name = "customer_id")
    private CustomerDto customer;

}

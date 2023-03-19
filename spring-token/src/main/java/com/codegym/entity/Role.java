package com.codegym.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

//    @OneToMany(fetch = FetchType.LAZY)
//    private List<Customer> customers;
//    @OneToMany(fetch = FetchType.LAZY)
//    private List<Partner> partners;

}

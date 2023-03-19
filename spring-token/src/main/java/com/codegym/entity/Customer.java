package com.codegym.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")

    private String lastName;

    private String email;

    private Boolean gender;

    private String address;

    private String image;

    private String username;
    private String password;

    private boolean status;

    private boolean active;

    @ManyToOne(targetEntity = Role.class)
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    private Role role;
//    @ManyToOne(targetEntity = Order.class)
//    @JoinColumn(name = "oder_id", referencedColumnName = "id")
//    private Order order;
//    @OneToMany(targetEntity = Pet.class)
//    private List<Pet> pets;
}

package com.codegym.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "customers")
public class CustomerDto {
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

    @ManyToOne(targetEntity = RoleDto.class)
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    private RoleDto role;
//    @ManyToOne(targetEntity = Order.class)
//    @JoinColumn(name = "oder_id", referencedColumnName = "id")
//    private Order order;
//    @OneToMany(targetEntity = Pet.class)
//    private List<Pet> pets;
}

package com.codegym.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity @AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="partners")
public class Partner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;

    private String email;

    private String address;

    private String image;

    private String username;
    private String password;

    private boolean status;

    private boolean active;
    private String type;
    private String description;

    @ManyToOne(targetEntity = Role.class)
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    private Role role;
//    @ManyToOne(targetEntity = PartnerService.class)
//    @JoinColumn(name = "partner_service_id")
//    private PartnerService partnerService;
//    @ManyToOne(targetEntity = Order.class)
//    @JoinColumn(name = "oder_id", referencedColumnName = "id")
//    private Order order;

//    @ManyToMany(fetch = FetchType.LAZY)
//    @JoinTable(name = "partner_service",
//            joinColumns = @JoinColumn(name = "partner_id"),
//            inverseJoinColumns = @JoinColumn(name = "service_id"))
//    @OnDelete(action = OnDeleteAction.CASCADE)
//    private Set<Role> roles = new HashSet<Role>();


}

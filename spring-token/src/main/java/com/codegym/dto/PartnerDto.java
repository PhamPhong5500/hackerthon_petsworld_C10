package com.codegym.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity @AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="partners")
public class PartnerDto {
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

    @ManyToOne(targetEntity = RoleDto.class)
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    private RoleDto role;
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

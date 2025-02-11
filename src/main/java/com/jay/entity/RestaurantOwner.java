package com.jay.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "owner_details")
public class RestaurantOwner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "owner_id")
    private int owner_id;

    @Column(name= "username" ,nullable = false, unique = true, length = 50)
    private String username;

    @Column(name = "owner_name")
    private String name;

    @Column(name = "passport")
    private String passport;

    @Column(name = "email")
    private String email;

    @Column(name = "mobile_number")
    private String mobile;

    @Column(name = "password")
    private String password;

    @ManyToMany(mappedBy = "owners", fetch = FetchType.LAZY)
    private Set<Restaurant> restaurants;



}
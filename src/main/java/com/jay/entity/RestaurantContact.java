package com.jay.entity;

import jakarta.persistence.*;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "restaurant_contact_details")
public class RestaurantContact {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contact_id")
    private int contact_id;

    @ManyToOne
    @JoinColumn(name = "address_id",referencedColumnName = "address_id")
    private RestaurantAddress restaurantAddress;

    @Column(name = "mobile")
    private String mobile;

    @Column(name = "restaurant_email")
    private String email;


}
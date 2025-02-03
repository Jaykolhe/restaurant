package com.jay.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "restaurant_legal_documents")
public class RestaurantLegalDocuments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "legal_id")
    private int legal_id;

    @OneToOne
    @JoinColumn(name = "address_id",referencedColumnName = "address_id")
    private RestaurantAddress restaurantAddress;

    @Column(name = "food_license")
    private String foodlicense;
}
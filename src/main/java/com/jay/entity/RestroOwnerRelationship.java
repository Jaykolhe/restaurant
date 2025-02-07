package com.jay.entity;

import jakarta.persistence.*;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "restaurant_owner_relationship")
public class RestroOwnerRelationship {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "owner_id",referencedColumnName = "owner_id")
    private RestaurantOwner restaurantOwner;

    @ManyToOne
    @JoinColumn(name = "restro_id",referencedColumnName = "restro_id")
    private Restaurant restaurant;


}
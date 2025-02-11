package com.jay.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "restaurant_details")
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "restro_id")
    private int restro_id;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "restaurant_owner_relation",
            joinColumns = @JoinColumn(name = "restro_id"),
            inverseJoinColumns = @JoinColumn(name = "owner_id")
    )
    private Set<RestaurantOwner> owners;

    @Column(name = "restaurant_name")
    private String name;

    @Column(name="restro_type")
    private String type;


}


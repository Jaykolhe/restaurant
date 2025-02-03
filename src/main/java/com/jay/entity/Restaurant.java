package com.jay.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "restaurant_details")
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "restro_id")
    private int restro_id;

    @Column(name = "restaurant_name")
    private String name;

    @Column(name="restro_type")
    private String type;

}

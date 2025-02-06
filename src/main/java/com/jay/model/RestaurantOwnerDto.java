package com.jay.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RestaurantOwnerDto {


    private int owner_id;
    private String name;
    private String passport;
    private String email;
    private String mobile;

}

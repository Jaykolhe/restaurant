package com.jay.model;


import lombok.*;

import java.util.List;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class RestaurantDto {


    private String restaurantName;
    private String ownerUserName;
    private String mobile;
    private String email;
    private String type;
    private String foodLicense;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String country;
    private String pincode;

}

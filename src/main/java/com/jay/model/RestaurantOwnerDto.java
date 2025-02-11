package com.jay.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class RestaurantOwnerDto {

    private String Username;
    private String name;
    private String passport;
    private String email;
    private String mobile;
    private String password;

}

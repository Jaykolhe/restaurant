package com.jay.model.Response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class RestaurantOwnerResponse {

    private String name;
    private String username;
    private String passport;
    private String email;
    private String mobile;

}

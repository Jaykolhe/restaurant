package com.jay.service;


import com.jay.model.Response.RestaurantOwnerResponse;
import com.jay.model.RestaurantOwnerDto;

import java.util.List;

public interface RestaurantOwnerService {

   RestaurantOwnerResponse addOwner(RestaurantOwnerDto restaurantOwnerDto);

   List<RestaurantOwnerResponse> getAllOwners();


}

package com.jay.service;

import com.jay.model.Response.RestaurantOwnerResponse;
import com.jay.model.RestaurantOwnerDto;

import java.util.List;

public interface RestaurantOwnerService {

    public boolean addOwner(RestaurantOwnerDto restaurantOwnerDto);

    public List<RestaurantOwnerResponse> getAllOwners();

    public RestaurantOwnerResponse getOwnerById(int id);

    public boolean deleteOwner(int id);
}

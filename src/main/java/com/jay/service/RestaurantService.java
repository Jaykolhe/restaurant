package com.jay.service;

import com.jay.model.Response.RestaurantResponse;
import com.jay.model.RestaurantDto;

import java.util.List;

public interface RestaurantService {

   public boolean addRestaurant(RestaurantDto restaurantDto);

   public List<RestaurantResponse> getAllRestaurants();

    public boolean deleteRestaurantById(int id);

    public boolean updateRestaurantById(int id,RestaurantDto restaurantDto);
}

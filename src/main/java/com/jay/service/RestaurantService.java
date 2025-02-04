package com.jay.service;

import com.jay.model.Response.RestaurantResponse;
import com.jay.model.RestaurantDto;

import java.util.List;

public interface RestaurantService {

    boolean addRestaurant(RestaurantDto restaurantDto);

    List<RestaurantResponse> getAllRestaurants();

    boolean deleteRestaurantById(int id);
}

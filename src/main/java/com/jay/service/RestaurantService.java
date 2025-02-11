package com.jay.service;

import com.jay.entity.Restaurant;
import com.jay.model.Response.RestaurantResponse;
import com.jay.model.RestaurantDto;

import java.util.List;

public interface RestaurantService {

        RestaurantDto addRestaurant(RestaurantDto restaurantDto);

        List<RestaurantResponse> getAllRestaurants();

        RestaurantDto updateRestaurantByName(String restaurantName, RestaurantDto restaurantDto);


        List<RestaurantResponse> getAllRestaurantsWithOwnerUserName(String ownerUserName);
}

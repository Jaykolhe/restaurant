package com.jay.service;

import com.jay.entity.Restaurant;
import com.jay.entity.RestaurantAddress;
import com.jay.model.ResaurantAddressDto;
import com.jay.model.Response.RestaurantAddressResponse;
import com.jay.model.RestaurantDto;

public interface RestaurantAddressService {

    public RestaurantAddress addAddress(RestaurantDto restaurantDto, Restaurant restaurant);

    public RestaurantAddressResponse getAddressByRestaurantName(String restaurantName);

}

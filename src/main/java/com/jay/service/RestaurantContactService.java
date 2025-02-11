package com.jay.service;

import com.jay.entity.Restaurant;
import com.jay.entity.RestaurantAddress;
import com.jay.entity.RestaurantContact;
import com.jay.model.RestaurantContactDto;
import com.jay.model.RestaurantDto;

public interface RestaurantContactService {


    public RestaurantContact addRestaurantContact(RestaurantDto restaurantDto, RestaurantAddress restaurantAddress);
}

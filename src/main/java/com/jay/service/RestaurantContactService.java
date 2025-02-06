package com.jay.service;

import com.jay.entity.Restaurant;
import com.jay.entity.RestaurantContact;
import com.jay.model.RestaurantContactDto;

public interface RestaurantContactService {


    public boolean addRestaurantContact(RestaurantContactDto restaurantContactDto,int address_id);
}

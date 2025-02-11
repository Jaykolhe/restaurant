package com.jay.service;

import com.jay.entity.RestaurantAddress;
import com.jay.entity.RestaurantLegalDocuments;
import com.jay.model.RestaurantDto;

public interface RestaurantLegalDocumentsService {

    public RestaurantLegalDocuments addLegalDocuments(RestaurantDto restaurantDto, RestaurantAddress restaurantAddress);
}

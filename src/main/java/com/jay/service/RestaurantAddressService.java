package com.jay.service;

import com.jay.model.ResaurantAddressDto;
import com.jay.model.Response.RestaurantAddressResponse;

public interface RestaurantAddressService {

    public boolean addAddress(ResaurantAddressDto resaurantAddressDto);

    public RestaurantAddressResponse getAddressById(int id);

}

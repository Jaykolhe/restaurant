package com.jay.service.serviceImpl;

import com.jay.entity.Restaurant;
import com.jay.exceptions.RestaurantException;
import com.jay.model.RestaurantDto;
import com.jay.repository.RestaurantRepository;
import com.jay.service.RestaurantService;
import org.springframework.stereotype.Service;


@Service
public class RestaurantServiceImpl implements RestaurantService {

    private final RestaurantRepository restaurantRepository;

    public RestaurantServiceImpl(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }


    @Override
    public boolean addRestaurant(RestaurantDto restaurantDto) {
    try {
        Restaurant restaurant = mapDtoToEntity(restaurantDto);
        Restaurant restro = restaurantRepository.save(restaurant);
        return true;
    }catch (RestaurantException e) {
        throw new RestaurantException("Failed to create restaurant");
    }
    }

    private Restaurant mapDtoToEntity(RestaurantDto restaurantDto) {

        return Restaurant.builder()
                .name(restaurantDto.getName())
                .type(restaurantDto.getType())
                .build();
    }
}

package com.jay.service.serviceImpl;

import com.jay.entity.Restaurant;
import com.jay.exceptions.RestaurantException;
import com.jay.model.Response.RestaurantResponse;
import com.jay.model.RestaurantDto;
import com.jay.repository.RestaurantRepository;
import com.jay.service.RestaurantService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


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

    }catch (RestaurantException e) {
        throw new RestaurantException("Failed to create restaurant");
    }
        return true;
    }


    public List<RestaurantResponse> getAllRestaurants(){
        try{
          List<Restaurant> restaurants = restaurantRepository.findAll();
          List<RestaurantResponse> listOfRestaurants = mapEntityToDto(restaurants);

          return listOfRestaurants;

        }catch (RestaurantException e){

            throw new RestaurantException("Failed to fetch restaurants details");
        }


    }



    private Restaurant mapDtoToEntity(RestaurantDto restaurantDto) {

        return Restaurant.builder()
                .name(restaurantDto.getName())
                .type(restaurantDto.getType())
                .build();
    }


    private List<RestaurantResponse> mapEntityToDto(List<Restaurant> restaurants){

        return restaurants.stream()
                .map(restaurant -> new RestaurantResponse(restaurant.getRestro_id(),restaurant.getName(),restaurant.getType()))
                .toList();
    }
}

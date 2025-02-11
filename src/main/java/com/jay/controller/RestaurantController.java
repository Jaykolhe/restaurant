package com.jay.controller;



import com.jay.model.Response.RestaurantResponse;
import com.jay.model.RestaurantDto;
import com.jay.service.RestaurantService;
import com.jay.service.serviceImpl.RestaurantServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/home/restaurant")
public class RestaurantController {


    private final RestaurantService restaurantService;

    public RestaurantController(RestaurantServiceImpl restaurantService) {
        this.restaurantService = restaurantService;
    }

    @PostMapping("/register")
    public ResponseEntity<RestaurantDto>  registerRestaurant(@RequestBody RestaurantDto restaurantDto){
      RestaurantDto restaurant = restaurantService.addRestaurant(restaurantDto);
       return new ResponseEntity<>(restaurant, HttpStatus.CREATED);

    }

    @GetMapping("/getAllRestaurants")
    public ResponseEntity<List<RestaurantResponse>> getAllRestaurants(){

        List<RestaurantResponse> restaurants = restaurantService.getAllRestaurants();

        return new ResponseEntity<>(restaurants,HttpStatus.OK);
    }


    @PutMapping("/update/{name}")
    public ResponseEntity<RestaurantDto> updateRestaurant(@PathVariable String name, @RequestBody RestaurantDto restaurantDto) {
        RestaurantDto restaurant = restaurantService.updateRestaurantByName(name, restaurantDto);
        return new ResponseEntity<>(restaurant, HttpStatus.OK);
    }


    @GetMapping("/owner/{ownerUserName}")
    public ResponseEntity<List<RestaurantResponse>> getRestaurantsByOwner(@PathVariable String ownerUserName) {
        List<RestaurantResponse> restaurants = restaurantService.getAllRestaurantsWithOwnerUserName(ownerUserName);
        return ResponseEntity.ok(restaurants);
    }




}

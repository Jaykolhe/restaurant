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
    public ResponseEntity<String>  registerRestaurant(@RequestBody RestaurantDto restaurantDto){
       restaurantService.addRestaurant(restaurantDto);
       return new ResponseEntity<>("Restro Added", HttpStatus.CREATED);

    }


    @GetMapping("/getAllRestaurants")
    public ResponseEntity<List<RestaurantResponse>> getAllRestaurants(){

        List<RestaurantResponse> restaurants = restaurantService.getAllRestaurants();

        return new ResponseEntity<>(restaurants,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRestaurant(@PathVariable Integer id){
        restaurantService.deleteRestaurantById(id);
        return new ResponseEntity<>("Restaurant Deleted ", HttpStatus.OK);
    }
}

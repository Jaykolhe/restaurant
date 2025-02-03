package com.jay.controller;


import com.jay.model.RestaurantDto;
import com.jay.service.RestaurantService;
import com.jay.service.serviceImpl.RestaurantServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}

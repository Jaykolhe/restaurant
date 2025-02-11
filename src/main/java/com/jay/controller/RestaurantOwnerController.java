package com.jay.controller;


import com.jay.model.Response.RestaurantOwnerResponse;
import com.jay.model.RestaurantOwnerDto;
import com.jay.service.RestaurantOwnerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurant/owner")
public class RestaurantOwnerController {

    private final RestaurantOwnerService restaurantOwnerService;

    public RestaurantOwnerController(RestaurantOwnerService restaurantOwnerService) {
        this.restaurantOwnerService = restaurantOwnerService;
    }



    @PostMapping("/add")
    public ResponseEntity<RestaurantOwnerResponse>  addOwner(@RequestBody RestaurantOwnerDto restaurantOwnerDto){

       RestaurantOwnerResponse restaurantOwnerResponse = restaurantOwnerService.addOwner(restaurantOwnerDto);

        return new ResponseEntity<>(restaurantOwnerResponse, HttpStatus.CREATED);
    }


    @GetMapping("/getAllOwners")
    public ResponseEntity<List<RestaurantOwnerResponse>> getAllOwners(){
        List<RestaurantOwnerResponse> restaurantOwnerResponses = restaurantOwnerService.getAllOwners();

        return new ResponseEntity<>(restaurantOwnerResponses,HttpStatus.OK);

    }







}

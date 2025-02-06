package com.jay.controller;


import com.jay.model.ResaurantAddressDto;
import com.jay.model.Response.RestaurantAddressResponse;
import com.jay.service.RestaurantAddressService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/restaurant/address")
public class RestaurantAddressController {


    private final RestaurantAddressService restaurantAddressService;


    public RestaurantAddressController(RestaurantAddressService restaurantAddressService) {
        this.restaurantAddressService = restaurantAddressService;
    }


    @PostMapping("/addAddress")
    public ResponseEntity<String>  addAddresss(@RequestBody ResaurantAddressDto resaurantAddressDto ){


        restaurantAddressService.addAddress(resaurantAddressDto);

        return new ResponseEntity<>("Restaurant Address Added", HttpStatus.CREATED);
    }


    @GetMapping("/{id}")
    public ResponseEntity<RestaurantAddressResponse> getRestaurantAddressById(@PathVariable int id){

        RestaurantAddressResponse restaurantAddressResponse = restaurantAddressService.getAddressById(id);

        return new ResponseEntity<>(restaurantAddressResponse,HttpStatus.OK);
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<String>  updateAddressById(@PathVariable int id, @RequestBody ResaurantAddressDto resaurantAddressDto){
        restaurantAddressService.updateAddressById(id,resaurantAddressDto);

        return new ResponseEntity<>("Address Updated",HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String>  deleteAddress(@PathVariable int id){

        restaurantAddressService.deleteAddress(id);

        return new ResponseEntity<>("Address Deleted", HttpStatus.OK);
    }
}

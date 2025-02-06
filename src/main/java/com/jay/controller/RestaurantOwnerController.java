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
    public ResponseEntity<String>  addOwner(@RequestBody RestaurantOwnerDto restaurantOwnerDto){

        restaurantOwnerService.addOwner(restaurantOwnerDto);

        return new ResponseEntity<>("Owner Added", HttpStatus.CREATED);
    }


    @GetMapping("/getAllOwners")
    public ResponseEntity<List<RestaurantOwnerResponse>> getAllOwners(){
        List<RestaurantOwnerResponse> restaurantOwnerResponses = restaurantOwnerService.getAllOwners();

        return new ResponseEntity<>(restaurantOwnerResponses,HttpStatus.OK);

    }


    @GetMapping("/{id}")
    public ResponseEntity<RestaurantOwnerResponse> getOwnerById(@PathVariable int id){
        RestaurantOwnerResponse restaurantOwnerResponse = restaurantOwnerService.getOwnerById(id);
        return  new ResponseEntity<>(restaurantOwnerResponse,HttpStatus.OK);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String>  deleteOwnerById(@PathVariable int id){

      restaurantOwnerService.deleteOwner(id);

        return new ResponseEntity<>("Owner Deleted",HttpStatus.OK);


    }




}

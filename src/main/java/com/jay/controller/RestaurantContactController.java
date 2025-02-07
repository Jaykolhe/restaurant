package com.jay.controller;


import com.jay.model.RestaurantContactDto;
import com.jay.service.RestaurantContactService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/restaurant/contact")
@AllArgsConstructor
public class RestaurantContactController {

    private final RestaurantContactService restaurantContactService;


    @PostMapping("/add/{address_id}")
    public ResponseEntity<String>  addContact(@RequestBody RestaurantContactDto restaurantContactDto , @PathVariable int address_id){

        restaurantContactService.addRestaurantContact(restaurantContactDto,address_id);

        return new ResponseEntity<>("Contact Added", HttpStatus.CREATED);
    }
}

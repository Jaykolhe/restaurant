package com.jay.controller;


import com.jay.service.RestroOwnerRelationshipService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/restaurant/restro-owner-relationship")
@AllArgsConstructor
public class RestaurantOwnerRelationshipController {


    private final RestroOwnerRelationshipService restroOwnerRelationshipService;

    @PostMapping("/assign")
    public ResponseEntity<String>  addOwnerToRestaurant(@RequestParam int owner_id, @RequestParam int restro_id){

        restroOwnerRelationshipService.addOwnerToRestaurant(owner_id,restro_id);

        return new ResponseEntity<>("Owner assigned to restaurant successfully", HttpStatus.CREATED);
    }


}

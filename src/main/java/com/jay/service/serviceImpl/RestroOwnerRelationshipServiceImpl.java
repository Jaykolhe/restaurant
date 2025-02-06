package com.jay.service.serviceImpl;

import com.jay.entity.Restaurant;
import com.jay.entity.RestaurantOwner;
import com.jay.entity.RestroOwnerRelationship;
import com.jay.exceptions.RestaurantException;
import com.jay.repository.RestaurantOwnerRelationshipRepository;
import com.jay.repository.RestaurantOwnerRepository;
import com.jay.repository.RestaurantRepository;
import com.jay.service.RestroOwnerRelationshipService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RestroOwnerRelationshipServiceImpl implements RestroOwnerRelationshipService {


    private final  RestaurantOwnerRelationshipRepository restaurantOwnerRelationshipRepository;

    private final RestaurantRepository restaurantRepository;

    private final RestaurantOwnerRepository restaurantOwnerRepository;



    @Override
    public boolean addOwnerToRestaurant(Integer owner_id, Integer restro_id) {
        Restaurant restaurant = restaurantRepository.findById(restro_id)
                .orElseThrow(()-> new RestaurantException("Restaurant not Found With Given Id"));

        RestaurantOwner restaurantOwner = restaurantOwnerRepository.findById(owner_id)
                .orElseThrow(()-> new RestaurantException("Owner is not Found for Given Id"));

        RestroOwnerRelationship relationship = new RestroOwnerRelationship();
        relationship.setRestaurant(restaurant);
        relationship.setRestaurantOwner(restaurantOwner);

        restaurantOwnerRelationshipRepository.save(relationship);

        return true;

    }



}

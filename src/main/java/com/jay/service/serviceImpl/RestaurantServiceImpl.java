package com.jay.service.serviceImpl;

import com.jay.entity.*;
import com.jay.exceptions.RestaurantException;
import com.jay.model.Response.RestaurantResponse;
import com.jay.model.RestaurantDto;
import com.jay.repository.RestaurantOwnerRepository;
import com.jay.repository.RestaurantRepository;
import com.jay.service.RestaurantAddressService;
import com.jay.service.RestaurantContactService;
import com.jay.service.RestaurantLegalDocumentsService;
import com.jay.service.RestaurantService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
@AllArgsConstructor
public class RestaurantServiceImpl implements RestaurantService {

    private final RestaurantRepository restaurantRepository;
    private final RestaurantOwnerRepository ownerRepository;
    private final RestaurantAddressService restaurantAddressService;
    private final RestaurantContactService restaurantContactService;
    private final RestaurantLegalDocumentsService restaurantLegalDocumentsService;


    @Override
    public RestaurantDto addRestaurant(RestaurantDto restaurantDto) {
        try {
            String username = restaurantDto.getOwnerUserName();

            if (username == null || username.isEmpty()) {
                throw new RestaurantException("Owner username is required.");
            }

            RestaurantOwner owner = ownerRepository.findByUsername(username)
                    .orElseThrow(() -> new RestaurantException("Owner not found: " + username));

            Set<RestaurantOwner> owners = Collections.singleton(owner); // Wrap in a Set

            Restaurant restaurant = mapDtoToEntity(restaurantDto, owners);
            Restaurant  savedRestaurant =  restaurantRepository.save(restaurant);
            RestaurantAddress restaurantAddress = restaurantAddressService.addAddress(restaurantDto,savedRestaurant);

            RestaurantContact restaurantContact =  restaurantContactService.addRestaurantContact(restaurantDto,restaurantAddress);

            RestaurantLegalDocuments restaurantLegalDocuments = restaurantLegalDocumentsService.addLegalDocuments(restaurantDto,restaurantAddress);

            RestaurantDto restaurantDto1 = mapEntityToDto(savedRestaurant,restaurantAddress, restaurantContact,restaurantLegalDocuments);

            return restaurantDto1;

        } catch (RestaurantException e) {
            throw new RestaurantException("Failed to create restaurant");
        }

    }




    public List<RestaurantResponse> getAllRestaurants(){
        try{
          List<Restaurant> restaurants = restaurantRepository.findAll();

          if(restaurants.isEmpty()){
              return Collections.emptyList();
          }
          List<RestaurantResponse> listOfRestaurants = mapEntityToDto(restaurants);

          return listOfRestaurants;

        }catch (RestaurantException e){

            throw new RestaurantException("Failed to fetch restaurants details");
        }


    }


    @Override
    public RestaurantDto updateRestaurantByName(String restaurantName, RestaurantDto restaurantDto) {
        Restaurant restaurant = restaurantRepository.findByName(restaurantName)
                .orElseThrow(() -> new RestaurantException("Restaurant does not exist with the given name"));

        if (restaurantDto.getRestaurantName() != null && !restaurantDto.getRestaurantName().isEmpty()) {
            restaurant.setName(restaurantDto.getRestaurantName());
        }

        if (restaurantDto.getType() != null && !restaurantDto.getType().isEmpty()) {
            restaurant.setType(restaurantDto.getType());
        }

        Restaurant updatedRestaurant =  restaurantRepository.save(restaurant);

        RestaurantDto restaurantDto1 = mapUpdatedEntityToDto(updatedRestaurant);
        return restaurantDto1;
    }


    @Override
    public List<RestaurantResponse> getAllRestaurantsWithOwnerUserName(String ownerUserName) {
        List<Restaurant> restaurants = restaurantRepository.findByOwnerUsername(ownerUserName);

        if (restaurants.isEmpty()) {
            throw new RestaurantException("No restaurants found for owner: " + ownerUserName);
        }

        return mapEntityToDto(restaurants);
    }


    private RestaurantDto mapUpdatedEntityToDto(Restaurant updatedRestaurant) {

        return  RestaurantDto.builder()
                .restaurantName(updatedRestaurant.getName())
                .type(updatedRestaurant.getType())
                .ownerUserName(updatedRestaurant.getOwners()
                        .stream()
                        .findFirst()
                        .map(RestaurantOwner::getUsername)
                        .orElse(null))
                .build();
    }


    private Restaurant mapDtoToEntity(RestaurantDto restaurantDto , Set<RestaurantOwner> owners ) {

        return Restaurant.builder()
                .name(restaurantDto.getRestaurantName())
                .type(restaurantDto.getType())
                .owners(owners)
                .build();
    }


    private RestaurantDto mapEntityToDto(Restaurant restaurant,
                                         RestaurantAddress address,
                                         RestaurantContact contact,
                                         RestaurantLegalDocuments legalDocs) {
        return RestaurantDto.builder()
                .restaurantName(restaurant.getName())
                .type(restaurant.getType())
                .ownerUserName(restaurant.getOwners().iterator().next().getUsername()) // Assuming single owner
                .addressLine1(address.getAddressLine1())
                .addressLine2(address.getAddressLine2())
                .city(address.getCity())
                .state(address.getState())
                .country(address.getCountry())
                .pincode(address.getPincode())
                .mobile(contact.getMobile())
                .email(contact.getEmail())
                .foodLicense(legalDocs.getFoodlicense())
                .build();
    }


    private List<RestaurantResponse> mapEntityToDto(List<Restaurant> restaurants){

        return restaurants.stream()
                .map(restaurant -> new RestaurantResponse(restaurant.getName(),restaurant.getType()))
                .toList();
    }
}

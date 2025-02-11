package com.jay.service.serviceImpl;

import com.jay.entity.Restaurant;
import com.jay.entity.RestaurantAddress;
import com.jay.exceptions.RestaurantException;
import com.jay.model.ResaurantAddressDto;
import com.jay.model.Response.RestaurantAddressResponse;
import com.jay.model.RestaurantDto;
import com.jay.repository.RestaurantAddressRepository;
import com.jay.repository.RestaurantLegalDocumentsRepository;
import com.jay.repository.RestaurantRepository;
import com.jay.service.RestaurantAddressService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RestaurantAddressServiceImpl implements RestaurantAddressService {

    private final RestaurantRepository restaurantRepository;
    private final RestaurantAddressRepository restaurantAddressRepository;


    @Override
    public RestaurantAddress addAddress(RestaurantDto restaurantDto, Restaurant restaurant) {
        if (restaurantDto == null || restaurant == null) {
            throw new RestaurantException("Invalid restaurant or address details.");
        }

        // Convert DTO to Address Entity
        RestaurantAddress restaurantAddress = mapDtoToAddressEntity(restaurantDto, restaurant);

        return restaurantAddressRepository.save(restaurantAddress);
    }



    @Override
    public RestaurantAddressResponse getAddressByRestaurantName(String restaurantName) {
        Restaurant restaurant = restaurantRepository.findByName(restaurantName)
                .orElseThrow(()-> new RestaurantException("Restaurant Not Found with name "+restaurantName));

        RestaurantAddress restaurantAddress = restaurantAddressRepository.findByRestaurant(restaurant)
                .orElseThrow(()-> new RestaurantException("Address not Found for restaurant "+restaurantName));

        RestaurantAddressResponse restaurantAddressResponse = mapEntityToDto(restaurantAddress);

        return  restaurantAddressResponse;
    }


    private RestaurantAddress mapDtoToAddressEntity(RestaurantDto restaurantDto, Restaurant restaurant) {

        return RestaurantAddress.builder()
                .addressLine1(restaurantDto.getAddressLine1())
                .addressLine2(restaurantDto.getAddressLine2())
                .city(restaurantDto.getCity())
                .state(restaurantDto.getState())
                .country(restaurantDto.getCountry())
                .pincode(restaurantDto.getPincode())
                .restaurant(restaurant)
                .build();
    }




    private RestaurantAddressResponse  mapEntityToDto(RestaurantAddress address) {
        return  RestaurantAddressResponse.builder()
                .addressLine1(address.getAddressLine1())
                .addressLine2(address.getAddressLine2())
                .city(address.getCity())
                .state(address.getState())
                .country(address.getCountry())
                .pincode(address.getPincode())
                .restaurantName(address.getRestaurant().getName())
                .build();

    }

}

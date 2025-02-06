package com.jay.service.serviceImpl;

import com.jay.entity.Restaurant;
import com.jay.entity.RestaurantAddress;
import com.jay.exceptions.RestaurantException;
import com.jay.model.ResaurantAddressDto;
import com.jay.model.Response.RestaurantAddressResponse;
import com.jay.repository.RestaurantAddressRepository;
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
    public boolean addAddress(ResaurantAddressDto resaurantAddressDto) {

        Restaurant restaurant = restaurantRepository.findById(resaurantAddressDto.getRestro_id())
                                                    .orElseThrow(()-> new RestaurantException("Restaurant Not Found"));

        RestaurantAddress address = mapDtoToEntity(resaurantAddressDto,restaurant);
        restaurantAddressRepository.save(address);

        return true;
    }

    @Override
    public RestaurantAddressResponse getAddressById(int id) {
        RestaurantAddress restaurantAddress = restaurantAddressRepository.findById(id)
                .orElseThrow(()-> new RestaurantException("Address not found with id"));

        return mapEntityToDto(restaurantAddress);

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

    private RestaurantAddress mapDtoToEntity(ResaurantAddressDto resaurantAddressDto, Restaurant restaurant) {
        return RestaurantAddress.builder()
                        .addressLine1(resaurantAddressDto.getAddressLine1())
                        .addressLine2(resaurantAddressDto.getAddressLine2())
                        .city(resaurantAddressDto.getCity())
                        .state(resaurantAddressDto.getState())
                        .country(resaurantAddressDto.getCountry())
                        .pincode(resaurantAddressDto.getPincode())
                        .restaurant(restaurant)
                        .build();

    }
}

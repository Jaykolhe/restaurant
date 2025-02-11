package com.jay.service.serviceImpl;

import com.jay.entity.RestaurantOwner;
import com.jay.model.Response.RestaurantOwnerResponse;
import com.jay.model.RestaurantOwnerDto;
import com.jay.repository.RestaurantOwnerRepository;
import com.jay.service.RestaurantOwnerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RestaurantOwnerServiceImpl implements RestaurantOwnerService {

    private final RestaurantOwnerRepository  restaurantOwnerRepository;


    @Override
    public RestaurantOwnerResponse addOwner(RestaurantOwnerDto restaurantOwnerDto) {

        RestaurantOwner restaurantOwner =mapDtoToEntity(restaurantOwnerDto);
        RestaurantOwner savedOwner = restaurantOwnerRepository.save(restaurantOwner);

        RestaurantOwnerResponse restaurantOwnerResponse = mapRestaurantOwnerEntityToDto(savedOwner);

      return restaurantOwnerResponse;

    }

    private RestaurantOwnerResponse mapRestaurantOwnerEntityToDto(RestaurantOwner savedOwner) {

        return RestaurantOwnerResponse.builder()
                .name(savedOwner.getName())
                .username(savedOwner.getUsername())
                .email(savedOwner.getEmail())
                .mobile(savedOwner.getMobile())
                .passport(savedOwner.getPassport())
                .build();
    }


    @Override
    public List<RestaurantOwnerResponse> getAllOwners() {
        List<RestaurantOwner> restaurantOwners = restaurantOwnerRepository.findAll();
        List<RestaurantOwnerResponse> restaurantOwnerResponses = mapEntityToDto(restaurantOwners);
        return restaurantOwnerResponses;
    }

    private List<RestaurantOwnerResponse> mapEntityToDto(List<RestaurantOwner> restaurantOwners) {

        return restaurantOwners.stream()
                .map(owner-> new RestaurantOwnerResponse(owner.getName(), owner.getEmail(),owner.getMobile(),owner.getPassport(),owner.getUsername()))
                .toList();
    }




    private RestaurantOwner mapDtoToEntity(RestaurantOwnerDto restaurantOwnerDto) {

        return RestaurantOwner.builder()
                .username(restaurantOwnerDto.getUsername())
                .name(restaurantOwnerDto.getName())
                .email(restaurantOwnerDto.getEmail())
                .mobile(restaurantOwnerDto.getMobile())
                .password(restaurantOwnerDto.getPassword())
                .passport(restaurantOwnerDto.getPassport())
                .build();

    }


}

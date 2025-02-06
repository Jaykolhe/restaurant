package com.jay.service.serviceImpl;

import com.jay.entity.RestaurantOwner;
import com.jay.exceptions.RestaurantException;
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
    public boolean addOwner(RestaurantOwnerDto restaurantOwnerDto) {

        RestaurantOwner restaurantOwner =mapDtoToEntity(restaurantOwnerDto);
        restaurantOwnerRepository.save(restaurantOwner);
        return true;

    }



    @Override
    public List<RestaurantOwnerResponse> getAllOwners() {
        List<RestaurantOwner> restaurantOwners = restaurantOwnerRepository.findAll();
        List<RestaurantOwnerResponse> restaurantOwnerResponses = mapEntityToDto(restaurantOwners);
        return restaurantOwnerResponses;
    }



    @Override
    public RestaurantOwnerResponse getOwnerById(int id) {
        RestaurantOwner restaurantOwner = restaurantOwnerRepository.findById(id)
                .orElseThrow(()-> new RestaurantException("Owner not Exits for Given Id"));


        return new RestaurantOwnerResponse(
                restaurantOwner.getName(), restaurantOwner.getEmail(), restaurantOwner.getMobile(),restaurantOwner.getPassport()
        );
    }

    @Override
    public boolean deleteOwner(int id) {
        restaurantOwnerRepository.deleteById(id);
        return true;
    }


    private List<RestaurantOwnerResponse> mapEntityToDto(List<RestaurantOwner> restaurantOwners) {

        return restaurantOwners.stream()
                .map(owner-> new RestaurantOwnerResponse(owner.getName(), owner.getEmail(),owner.getMobile(),owner.getPassport()))
                .toList();
    }




    private RestaurantOwner mapDtoToEntity(RestaurantOwnerDto restaurantOwnerDto) {

        return RestaurantOwner.builder()
                .name(restaurantOwnerDto.getName())
                .email(restaurantOwnerDto.getEmail())
                .mobile(restaurantOwnerDto.getMobile())
                .passport(restaurantOwnerDto.getPassport())
                .build();

    }


}

package com.jay.service.serviceImpl;

import com.jay.entity.RestaurantAddress;
import com.jay.entity.RestaurantContact;
import com.jay.exceptions.RestaurantException;
import com.jay.model.RestaurantContactDto;
import com.jay.repository.RestaurantAddressRepository;
import com.jay.repository.RestaurantContactRepository;
import com.jay.service.RestaurantContactService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RestaurantContactServiceImpl  implements RestaurantContactService {


    private final RestaurantContactRepository restaurantContactRepository;

    private final RestaurantAddressRepository restaurantAddressRepository;


    @Override
    public boolean addRestaurantContact(RestaurantContactDto restaurantContactDto, int address_id) {
        RestaurantAddress restaurantAddress = restaurantAddressRepository.findById(address_id)
                .orElseThrow(()-> new RestaurantException("Restaurant Address is not Found with given Id"));

        RestaurantContact restaurantContact = new RestaurantContact();
        restaurantContact.setRestaurantAddress(restaurantAddress);
        restaurantContact.setMobile(restaurantContactDto.getMobile());
        restaurantContact.setEmail(restaurantContact.getEmail());

        restaurantContactRepository.save(restaurantContact);

       return true;

    }


}

package com.jay.service.serviceImpl;

import com.jay.entity.RestaurantAddress;
import com.jay.entity.RestaurantContact;
import com.jay.exceptions.RestaurantException;
import com.jay.model.RestaurantContactDto;
import com.jay.model.RestaurantDto;
import com.jay.repository.RestaurantAddressRepository;
import com.jay.repository.RestaurantContactRepository;
import com.jay.service.RestaurantContactService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RestaurantContactServiceImpl  implements RestaurantContactService {


    private final RestaurantContactRepository restaurantContactRepository;

    @Override
    public RestaurantContact addRestaurantContact(RestaurantDto restaurantDto, RestaurantAddress restaurantAddress) {
        if (restaurantDto.getMobile() == null || restaurantDto.getMobile().isEmpty()) {
            throw new RestaurantException("Mobile number is required.");
        }

        // map Dto to entity
        RestaurantContact contact = new RestaurantContact();
        contact.setMobile(restaurantDto.getMobile());
        contact.setEmail(restaurantDto.getEmail());
        contact.setRestaurantAddress(restaurantAddress);

        return restaurantContactRepository.save(contact);

    }
}

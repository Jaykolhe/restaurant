package com.jay.service.serviceImpl;

import com.jay.entity.RestaurantAddress;
import com.jay.entity.RestaurantLegalDocuments;
import com.jay.exceptions.RestaurantException;
import com.jay.model.RestaurantDto;
import com.jay.repository.RestaurantLegalDocumentsRepository;
import com.jay.service.RestaurantLegalDocumentsService;
import org.springframework.stereotype.Service;

@Service
public class RestaurantLegalDocumentsServiceImpl implements RestaurantLegalDocumentsService {

    private final RestaurantLegalDocumentsRepository legalDocumentsRepository;

    public RestaurantLegalDocumentsServiceImpl(RestaurantLegalDocumentsRepository legalDocumentsRepository) {
        this.legalDocumentsRepository = legalDocumentsRepository;
    }

    @Override
    public RestaurantLegalDocuments addLegalDocuments(RestaurantDto restaurantDto, RestaurantAddress restaurantAddress) {
        if (restaurantDto.getFoodLicense() == null || restaurantDto.getFoodLicense().isEmpty()) {
            throw new RestaurantException("License number is required.");
        }

        // Map Dto to entity
        RestaurantLegalDocuments legalDocuments = new RestaurantLegalDocuments();
        legalDocuments.setFoodlicense(restaurantDto.getFoodLicense());
        legalDocuments.setRestaurantAddress(restaurantAddress);
        return legalDocumentsRepository.save(legalDocuments);
    }
}

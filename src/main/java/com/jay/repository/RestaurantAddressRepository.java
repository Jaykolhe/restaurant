package com.jay.repository;


import com.jay.entity.Restaurant;
import com.jay.entity.RestaurantAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RestaurantAddressRepository extends JpaRepository<RestaurantAddress,Integer> {
    Optional<RestaurantAddress> findByRestaurant(Restaurant restaurant);
}

package com.jay.repository;


import com.jay.entity.RestaurantOwner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RestaurantOwnerRepository extends JpaRepository<RestaurantOwner,Integer> {

    @Query("SELECT o FROM RestaurantOwner o WHERE o.username = :username")
    Optional<RestaurantOwner> findByUsername(@Param("username") String username);
}

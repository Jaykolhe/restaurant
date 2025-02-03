package com.jay.repository;


import com.jay.entity.RestaurantContact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantContactRepository extends JpaRepository<RestaurantContact,Integer> {
}

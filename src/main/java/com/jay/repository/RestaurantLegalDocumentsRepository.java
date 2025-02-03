package com.jay.repository;


import com.jay.entity.RestaurantLegalDocuments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantLegalDocumentsRepository extends JpaRepository<RestaurantLegalDocuments,Integer> {
}

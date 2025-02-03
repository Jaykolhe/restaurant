package com.jay.repository;


import com.jay.entity.RestroOwnerRelationship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantOwnerRelationshipRepository extends JpaRepository<RestroOwnerRelationship,Integer> {
}

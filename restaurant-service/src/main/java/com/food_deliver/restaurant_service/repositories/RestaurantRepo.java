package com.food_deliver.restaurant_service.repositories;

import com.food_deliver.restaurant_service.entity.RestaurantEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RestaurantRepo extends JpaRepository<RestaurantEntity, Long> {

    Optional<RestaurantEntity> findByEmail(String email);

    Boolean existsByEmail(String email);
}
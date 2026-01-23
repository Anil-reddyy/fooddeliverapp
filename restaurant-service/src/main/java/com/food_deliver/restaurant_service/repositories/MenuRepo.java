package com.food_deliver.restaurant_service.repositories;

import com.food_deliver.restaurant_service.entity.MenuEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface MenuRepo extends JpaRepository<MenuEntity, Long> {

    List<MenuEntity> findByRestaurantId(Long restaurant_Id);
}

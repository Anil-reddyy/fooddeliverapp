package com.food_deliver.restaurant_service.service;

import com.food_deliver.restaurant_service.entity.MenuEntity;
import com.food_deliver.restaurant_service.entity.RestaurantEntity;
import com.food_deliver.restaurant_service.repositories.MenuRepo;
import com.food_deliver.restaurant_service.repositories.RestaurantRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RestaurantService {
    private final RestaurantRepo rp;
    private final MenuRepo mp;

    public List<RestaurantEntity> getAllRestaurants(){
        return rp.findAll();
    }
    public List<MenuEntity> getMenubyRestaurantId(Long restaurant_Id){
        return mp.findByRestaurantId(restaurant_Id);
    }
}

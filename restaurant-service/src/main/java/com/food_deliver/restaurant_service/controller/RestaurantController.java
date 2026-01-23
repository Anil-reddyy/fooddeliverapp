package com.food_deliver.restaurant_service.controller;

import com.food_deliver.restaurant_service.entity.MenuEntity;
import com.food_deliver.restaurant_service.entity.RestaurantEntity;
import com.food_deliver.restaurant_service.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/restaurants")
public class RestaurantController {
    private final RestaurantService rs;
    @GetMapping("all")
    public List<RestaurantEntity> getRestaurants(){
        return rs.getAllRestaurants();
    }
    @GetMapping("/{id}/menu")
    public List<MenuEntity>getMenubyRest(@PathVariable Long id){
        return rs.getMenubyRestaurantId(id);
    }

}

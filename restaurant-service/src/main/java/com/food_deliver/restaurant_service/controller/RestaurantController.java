package com.food_deliver.restaurant_service.controller;





import com.food_deliver.restaurant_service.entity.RestaurantEntity;
import com.food_deliver.restaurant_service.service.RestaurantService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

@RestController

@RequestMapping("/api/restaurant")

@RequiredArgsConstructor

public class RestaurantController {

    private final RestaurantService restaurantService;

    // Register restaurant (public)

    @PostMapping("/register")

    public ResponseEntity<?> register(@RequestBody RestaurantEntity restaurant) {

        return ResponseEntity.ok(restaurantService.register(restaurant));

    }

    // Login restaurant (public) → returns JWT token
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {

        String token = restaurantService.login(request.getEmail(), request.getPassword());

        return ResponseEntity.ok(new JwtResponse(token));
    }

    // DTO classes

    public static class LoginRequest {

        private String email;

        private String password;

        public String getEmail() { return email; }

        public void setEmail(String email) { this.email = email; }

        public String getPassword() { return password; }

        public void setPassword(String password) { this.password = password; }

    }

    public static class JwtResponse {

        private String token;

        public JwtResponse(String token) { this.token = token; }

        public String getToken() { return token; }

        public void setToken(String token) { this.token = token; }

    }

}


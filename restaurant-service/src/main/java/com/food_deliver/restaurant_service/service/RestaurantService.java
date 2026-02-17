package com.food_deliver.restaurant_service.service;

import com.food_deliver.restaurant_service.Security.JwtUtil;
import com.food_deliver.restaurant_service.entity.RestaurantEntity;

import com.food_deliver.restaurant_service.repositories.RestaurantRepo;



import lombok.RequiredArgsConstructor;

import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.stereotype.Service;

@Service

@RequiredArgsConstructor

public class RestaurantService {

	private final RestaurantRepo restaurantRepository;

	private final PasswordEncoder passwordEncoder;

	private final JwtUtil jwtUtil;   // ✅ ADD THIS

	// Register

	public RestaurantEntity register(RestaurantEntity restaurant) {

		if (restaurantRepository.existsByEmail(restaurant.getEmail())) {

			throw new RuntimeException("Email already registered");

		}

		restaurant.setPassword(passwordEncoder.encode(restaurant.getPassword()));

		return restaurantRepository.save(restaurant);

	}

	// ✅ Login → return JWT token

	public String login(String email, String password) {

		RestaurantEntity restaurant = restaurantRepository.findByEmail(email)

				.orElseThrow(() -> new RuntimeException("Invalid email or password"));

		if (!passwordEncoder.matches(password, restaurant.getPassword())) {

			throw new RuntimeException("Invalid email or password");

		}

		// 🔥 Generate JWT token here

		return jwtUtil.generateToken(restaurant.getEmail());

	}

}


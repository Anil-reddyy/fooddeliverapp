package com.food_delivery.auth_service.Repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.food_delivery.auth_service.Entity.UserEntity;

public interface AuthRepo extends JpaRepository<UserEntity, Long> {

  Optional<UserEntity>findByEmail(String emial);

}

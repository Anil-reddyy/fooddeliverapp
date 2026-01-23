package com.food_delivery.auth_service.controller;

import com.food_delivery.auth_service.AuthService.AuthService;
import com.food_delivery.auth_service.dto.AuthRequest;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    //Register Api
    @PostMapping("/register")
    public String register(@Valid @RequestBody AuthRequest request) {
        authService.register(request.getEmail(), request.getPassword());
        return "REGISTER_SUCCESS";
    }

   //Login API
    @PostMapping("/login")
    public String login(@Valid @RequestBody AuthRequest request) {
        return authService.login(request.getEmail(), request.getPassword());
    }
}

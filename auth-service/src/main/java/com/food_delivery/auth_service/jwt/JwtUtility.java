package com.food_delivery.auth_service.jwt;

import com.food_delivery.auth_service.enumm.Role;
import io.jsonwebtoken.Claims;

import io.jsonwebtoken.Jwts;

import io.jsonwebtoken.security.Keys;

import org.springframework.stereotype.Component;

import java.util.Date;

import java.util.List;

import java.util.Set;

import java.util.stream.Collectors;

@Component

public class JwtUtility {

    private final String SECRET = "mysecretkeymysecretkeymysecretkeymysecretkey";

    // Generate token

    public String generateToken(String email, Set<Role> roles) {

        List<String> roleList = roles.stream().map(Enum::name).collect(Collectors.toList());

        return Jwts.builder()

                .setSubject(email)

                .claim("roles", roleList)

                .setIssuedAt(new Date())

                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))

                .signWith(Keys.hmacShaKeyFor(SECRET.getBytes()))

                .compact();

    }

    // Extract email

    public String extractEmail(String token) {

        return extractClaims(token).getSubject();

    }

    // Extract roles as List<String>

    public List<String> extractRoles(String token) {

        return extractClaims(token).get("roles", List.class);

    }

    // Extract claims

    public Claims extractClaims(String token) {

        return Jwts.parserBuilder()

                .setSigningKey(SECRET.getBytes())

                .build()

                .parseClaimsJws(token)

                .getBody();

    }

    // Validate

    public boolean validateToken(String token) {

        try {

            extractClaims(token);

            return true;

        } catch (Exception e) {

            return false;

        }

    }

}

 
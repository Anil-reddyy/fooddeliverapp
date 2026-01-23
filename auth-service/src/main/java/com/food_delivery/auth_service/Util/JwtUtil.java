package com.food_delivery.auth_service.Util;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtil {

    // ⚠️ This secret MUST be same in API Gateway later
    private static final String SECRET_KEY = "my_secret_key_123";

    public String generateToken(String email) {

        return Jwts.builder()
                .setSubject(email)              // who the user is
                .setIssuedAt(new Date())        // token creation time
                .setExpiration(
                        new Date(System.currentTimeMillis() + 60 * 60 * 1000)
                )                               // 1 hour expiry
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }
}

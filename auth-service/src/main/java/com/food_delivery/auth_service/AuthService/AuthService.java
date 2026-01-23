package com.food_delivery.auth_service.AuthService;



import com.food_delivery.auth_service.Entity.UserEntity;
import com.food_delivery.auth_service.Repo.AuthRepo;
import com.food_delivery.auth_service.Util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthRepo repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public void register(String email, String password) {

        if (repository.findByEmail(email).isPresent()) {
            throw new com.food_delivery.auth_service.exceptions.UserAlreadyExistsException("User already exists with this email");
        }

        UserEntity user = new UserEntity();
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(password));

        repository.save(user);
    }

    public String login(String email, String password) {

        UserEntity user = repository.findByEmail(email)
                .orElseThrow(() ->
                        new com.food_delivery.auth_service.exceptions.UserNotFoundException("User not found")
                );

        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new com.food_delivery.auth_service.exceptions.InvalidCredentialsException("Invalid email or password");
        }

        return jwtUtil.generateToken(email);
    }
}

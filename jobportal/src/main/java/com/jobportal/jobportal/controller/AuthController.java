package com.jobportal.jobportal.controller;

import com.jobportal.jobportal.dto.LoginRequestDTO;
import com.jobportal.jobportal.dto.UserRegisterDTO;
import com.jobportal.jobportal.model.User;
import com.jobportal.jobportal.repository.UserRepository;
import com.jobportal.jobportal.util.JwtUtil;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;
import java.util.Collections;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JwtUtil jwtUtil;



    @PostMapping("/login")

    public ResponseEntity<?> login(@RequestBody LoginRequestDTO request) {

        Optional<User> userOpt = userRepository.findByEmailAndPassword(

                request.getEmail(), request.getPassword()

        );

        if (userOpt.isEmpty()) {

            return ResponseEntity.status(401).body("Identifiants invalides");

        }

        User user = userOpt.get();

        String token = jwtUtil.generateToken(user.getId(), user.getRole().name());

        return ResponseEntity.ok(Collections.singletonMap("token", token));

    }



    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody UserRegisterDTO dto) {
        if (userRepository.findByEmail(dto.getEmail()).isPresent()) {
            return ResponseEntity.badRequest().body("Email déjà utilisé.");
        }

        if (!dto.getPassword().matches("\\d{4}")) {
            return ResponseEntity.badRequest().body("Le mot de passe doit contenir exactement 4 chiffres.");
        }

        User user = new User();
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setEmail(dto.getEmail());
        user.setPhone(dto.getPhone());
        user.setPassword(dto.getPassword());
        user.setRole(dto.getRole());

        return ResponseEntity.ok(userRepository.save(user));
    }


}

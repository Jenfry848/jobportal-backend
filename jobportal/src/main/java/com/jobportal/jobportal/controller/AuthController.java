package com.jobportal.jobportal.controller;

import com.jobportal.jobportal.dto.UserRegisterDTO;
import com.jobportal.jobportal.model.User;
import com.jobportal.jobportal.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestParam String email, @RequestParam String password) {
        // Vérification basique du code PIN (4 chiffres)
        if (password.length() != 4 || !password.matches("\\d{4}")) {
            return ResponseEntity.badRequest().body(null);
        }

        Optional<User> user = userRepository.findByEmailAndPassword(email, password);
        return user.map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(401).build()); // Unauthorized
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

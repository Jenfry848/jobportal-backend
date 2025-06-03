// UserService.java

package com.jobportal.jobportal.service;

import com.jobportal.jobportal.model.User;
import com.jobportal.jobportal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Créer un utilisateur
    public User createUser(User user) {
        return userRepository.save(user);
    }

    // Récupérer tous les utilisateurs
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Récupérer un utilisateur par ID
    public Optional<User> getUserById(UUID id) {
        return userRepository.findById(id);
    }

    // Supprimer un utilisateur par ID
    public void deleteUser(UUID id) {
        userRepository.deleteById(id);
    }

    // ✅ Corrigé : rechercher un utilisateur par email
    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}

package com.jobportal.jobportal.service;

import com.jobportal.jobportal.model.User;
import com.jobportal.jobportal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    // Supprimer un utilisateur par ID
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    // (Facultatif) Rechercher un utilisateur par e-mail
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}

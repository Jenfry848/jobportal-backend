package com.jobportal.jobportal.repository;

import com.jobportal.jobportal.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Tu peux ajouter des méthodes personnalisées ici, par exemple :
    User findByEmail(String email);
}

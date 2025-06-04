package com.jobportal.jobportal.repository;

import com.jobportal.jobportal.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface JobRepository extends JpaRepository<Job, UUID> {

    // Recherche filtrée optionnelle
    List<Job> findByLocationContainingIgnoreCase(String location);
    List<Job> findByTypeContainingIgnoreCase(String type);
    List<Job> findByExperienceLevelContainingIgnoreCase(String experienceLevel);
    List<Job> findByTitleContainingIgnoreCase(String title);
    List<Job> findByTitle(String title);
    List<Job> findByCreatedById(UUID userId);
    boolean existsByTitleAndLocationAndCompany(String title, String location, String company);
}

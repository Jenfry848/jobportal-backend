package com.jobportal.jobportal.repository;

import com.jobportal.jobportal.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {

    // Recherche filtrée optionnelle
    List<Job> findByLocationContainingIgnoreCase(String location);
    List<Job> findByTypeContainingIgnoreCase(String type);
    List<Job> findByExperienceLevelContainingIgnoreCase(String experienceLevel);
    List<Job> findByTitleContainingIgnoreCase(String title);
}

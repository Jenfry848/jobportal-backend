package com.jobportal.jobportal.repository;

import com.jobportal.jobportal.model.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, UUID> {

    // Liste des candidatures associées à une offre d’emploi
    List<Application> findByJobId(UUID jobId);
    boolean existsByUserIdAndJobId(UUID userId, UUID jobId);
}

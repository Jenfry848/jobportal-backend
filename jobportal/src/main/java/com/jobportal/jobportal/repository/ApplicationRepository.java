package com.jobportal.jobportal.repository;

import com.jobportal.jobportal.model.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long> {

    // Liste des candidatures associées à une offre d’emploi
    List<Application> findByJobId(Long jobId);
}

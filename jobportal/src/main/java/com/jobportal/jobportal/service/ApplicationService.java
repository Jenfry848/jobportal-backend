package com.jobportal.jobportal.service;

import com.jobportal.jobportal.enums.Role;
import com.jobportal.jobportal.model.Application;
import com.jobportal.jobportal.model.Job;
import com.jobportal.jobportal.model.User;
import com.jobportal.jobportal.repository.ApplicationRepository;
import com.jobportal.jobportal.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ApplicationService {

    @Autowired
    private ApplicationRepository applicationRepository;

    @Autowired
    private JobRepository jobRepository;

    //  Créer une candidature
    public Application createApplication(Application application, UUID jobId, User user) {
        if (user.getRole() != Role.CANDIDATE) {
            throw new IllegalArgumentException("Seuls les candidats peuvent postuler à une offre.");
        }

        Optional<Job> jobOptional = jobRepository.findById(jobId);
        if (jobOptional.isEmpty()) {
            throw new IllegalArgumentException("Offre d’emploi introuvable.");
        }

        application.setUser(user);
        application.setJob(jobOptional.get());

        return applicationRepository.save(application);
    }


    //  Récupérer toutes les candidatures
    public List<Application> getAllApplications() {
        return applicationRepository.findAll();
    }

    //  Récupérer une candidature par ID
    public Optional<Application> getApplicationById(UUID id) {
        return applicationRepository.findById(id);
    }

    //  Récupérer toutes les candidatures pour un job donné
    public List<Application> getApplicationsByJobId(UUID jobId) {
        return applicationRepository.findByJobId(jobId);
    }

    //  Supprimer une candidature
    public void deleteApplication(UUID id) {
        applicationRepository.deleteById(id);
    }
}

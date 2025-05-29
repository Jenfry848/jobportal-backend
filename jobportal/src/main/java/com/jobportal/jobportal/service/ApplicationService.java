package com.jobportal.jobportal.service;

import com.jobportal.jobportal.model.Application;
import com.jobportal.jobportal.model.Job;
import com.jobportal.jobportal.repository.ApplicationRepository;
import com.jobportal.jobportal.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApplicationService {

    @Autowired
    private ApplicationRepository applicationRepository;

    @Autowired
    private JobRepository jobRepository;

    // ➕ Créer une candidature
    public Application createApplication(Application application, Long jobId) {
        Optional<Job> jobOptional = jobRepository.findById(jobId);
        if (jobOptional.isPresent()) {
            application.setJob(jobOptional.get());
            return applicationRepository.save(application);
        } else {
            throw new IllegalArgumentException("Offre d’emploi introuvable pour l'ID : " + jobId);
        }
    }

    // 📄 Récupérer toutes les candidatures
    public List<Application> getAllApplications() {
        return applicationRepository.findAll();
    }

    // 🔍 Récupérer une candidature par ID
    public Optional<Application> getApplicationById(Long id) {
        return applicationRepository.findById(id);
    }

    // 📥 Récupérer toutes les candidatures pour un job donné
    public List<Application> getApplicationsByJobId(Long jobId) {
        return applicationRepository.findByJobId(jobId);
    }

    // ❌ Supprimer une candidature
    public void deleteApplication(Long id) {
        applicationRepository.deleteById(id);
    }
}

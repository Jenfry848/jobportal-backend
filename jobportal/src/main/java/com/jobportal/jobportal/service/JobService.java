package com.jobportal.jobportal.service;

import com.jobportal.jobportal.model.Job;
import com.jobportal.jobportal.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class JobService {

    @Autowired
    private JobRepository jobRepository;

    //  Créer une nouvelle offre d’emploi
    public Job createJob(Job job) {
        if (job.getPostedDate() == null) {
            job.setPostedDate(LocalDate.now());
        }
        if (job.getCreatedBy() == null || job.getCreatedBy().getRole() == null) {
            throw new IllegalArgumentException("Utilisateur créateur manquant.");
        }

        if (job.getCreatedBy().getRole().name().equals("CANDIDATE")) {
            throw new IllegalArgumentException("Seuls les recruteurs peuvent publier des offres.");
        }

        boolean exists = jobRepository.existsByTitleAndLocationAndCompany(
                job.getTitle(),
                job.getLocation(),
                job.getCompany()
        );
        if (exists){
            throw new IllegalArgumentException("une offre identique existe dejà");
        }

        return jobRepository.save(job);
    }


    //  Récupérer toutes les offres
    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    //  Récupérer une offre par ID
    public Optional<Job> getJobById(UUID id) {
        return jobRepository.findById(id);
    }

    //  Supprimer une offre par ID
    public void deleteJob(UUID id) {
        jobRepository.deleteById(id);
    }

    //  Rechercher par lieu
    public List<Job> searchByLocation(String location) {
        return jobRepository.findByLocationContainingIgnoreCase(location);
    }

    //  Rechercher par type
    public List<Job> searchByType(String type) {
        return jobRepository.findByTypeContainingIgnoreCase(type);
    }

    //  Rechercher par niveau d'expérience
    public List<Job> searchByExperienceLevel(String level) {
        return jobRepository.findByExperienceLevelContainingIgnoreCase(level);
    }

    //  Rechercher par titre
    public List<Job> searchByTitle(String title) {
        return jobRepository.findByTitleContainingIgnoreCase(title);
    }
}

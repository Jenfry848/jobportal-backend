package com.jobportal.jobportal.service;

import com.jobportal.jobportal.model.Job;
import com.jobportal.jobportal.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobService {

    @Autowired
    private JobRepository jobRepository;

    // ➕ Créer une nouvelle offre d’emploi
    public Job createJob(Job job) {
        return jobRepository.save(job);
    }

    // 📄 Récupérer toutes les offres
    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    // 🔍 Récupérer une offre par ID
    public Optional<Job> getJobById(Long id) {
        return jobRepository.findById(id);
    }

    // ❌ Supprimer une offre par ID
    public void deleteJob(Long id) {
        jobRepository.deleteById(id);
    }

    // 🔎 Rechercher par lieu
    public List<Job> searchByLocation(String location) {
        return jobRepository.findByLocationContainingIgnoreCase(location);
    }

    // 🔎 Rechercher par type
    public List<Job> searchByType(String type) {
        return jobRepository.findByTypeContainingIgnoreCase(type);
    }

    // 🔎 Rechercher par niveau d'expérience
    public List<Job> searchByExperienceLevel(String level) {
        return jobRepository.findByExperienceLevelContainingIgnoreCase(level);
    }

    // 🔎 Rechercher par titre
    public List<Job> searchByTitle(String title) {
        return jobRepository.findByTitleContainingIgnoreCase(title);
    }
}

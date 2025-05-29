package com.jobportal.jobportal.controller;

import com.jobportal.jobportal.model.Job;
import com.jobportal.jobportal.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobs")
@CrossOrigin(origins = "*")
public class JobController {

    @Autowired
    private JobService jobService;

    // ➕ Ajouter une nouvelle offre
    @PostMapping
    public ResponseEntity<Job> createJob(@RequestBody Job job) {
        return ResponseEntity.ok(jobService.createJob(job));
    }

    // 📄 Récupérer toutes les offres
    @GetMapping
    public ResponseEntity<List<Job>> getAllJobs() {
        return ResponseEntity.ok(jobService.getAllJobs());
    }

    // 🔍 Récupérer une offre par ID
    @GetMapping("/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable Long id) {
        return jobService.getJobById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // ❌ Supprimer une offre
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJob(@PathVariable Long id) {
        jobService.deleteJob(id);
        return ResponseEntity.noContent().build();
    }

    // 🔎 Rechercher par lieu
    @GetMapping("/search/location")
    public ResponseEntity<List<Job>> searchByLocation(@RequestParam String location) {
        return ResponseEntity.ok(jobService.searchByLocation(location));
    }

    // 🔎 Rechercher par type
    @GetMapping("/search/type")
    public ResponseEntity<List<Job>> searchByType(@RequestParam String type) {
        return ResponseEntity.ok(jobService.searchByType(type));
    }

    // 🔎 Rechercher par niveau d'expérience
    @GetMapping("/search/experience")
    public ResponseEntity<List<Job>> searchByExperience(@RequestParam String level) {
        return ResponseEntity.ok(jobService.searchByExperienceLevel(level));
    }

    // 🔎 Rechercher par titre
    @GetMapping("/search/title")
    public ResponseEntity<List<Job>> searchByTitle(@RequestParam String title) {
        return ResponseEntity.ok(jobService.searchByTitle(title));
    }
}

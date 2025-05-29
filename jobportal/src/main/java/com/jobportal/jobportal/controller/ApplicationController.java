package com.jobportal.jobportal.controller;

import com.jobportal.jobportal.model.Application;
import com.jobportal.jobportal.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/applications")
@CrossOrigin(origins = "*")
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    // ➕ Postuler à une offre (via son ID)
    @PostMapping("/job/{jobId}")
    public ResponseEntity<Application> createApplication(@RequestBody Application application,
                                                         @PathVariable Long jobId) {
        return ResponseEntity.ok(applicationService.createApplication(application, jobId));
    }

    // 📄 Obtenir toutes les candidatures
    @GetMapping
    public ResponseEntity<List<Application>> getAllApplications() {
        return ResponseEntity.ok(applicationService.getAllApplications());
    }

    // 🔍 Candidature par ID
    @GetMapping("/{id}")
    public ResponseEntity<Application> getApplicationById(@PathVariable Long id) {
        return applicationService.getApplicationById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // 📥 Toutes les candidatures pour une offre spécifique
    @GetMapping("/job/{jobId}")
    public ResponseEntity<List<Application>> getApplicationsByJobId(@PathVariable Long jobId) {
        return ResponseEntity.ok(applicationService.getApplicationsByJobId(jobId));
    }

    // ❌ Supprimer une candidature
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteApplication(@PathVariable Long id) {
        applicationService.deleteApplication(id);
        return ResponseEntity.noContent().build();
    }
}

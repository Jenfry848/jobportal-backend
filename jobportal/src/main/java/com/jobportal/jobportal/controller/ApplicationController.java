package com.jobportal.jobportal.controller;

import com.jobportal.jobportal.dto.ApplicationRequestDTO;
import com.jobportal.jobportal.model.Application;
import com.jobportal.jobportal.model.User;
import com.jobportal.jobportal.repository.UserRepository;
import com.jobportal.jobportal.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("v1/applications")
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/job/{jobId}")

    public ResponseEntity<?> createApplication(@PathVariable UUID jobId, @RequestBody ApplicationRequestDTO dto) {

        if (dto.getUserId() == null) {

            return ResponseEntity.badRequest().body("Utilisateur manquant");

        }

        Optional<User> user = userRepository.findById(dto.getUserId());

        if (user.isEmpty()) {

            return ResponseEntity.badRequest().body("Utilisateur introuvable");

        }

        Application application = new Application();

        application.setUser(user.get());

        //application.setJob(null); // sera set dans le service

        application.setCoverLetter(dto.getCoverLetter());

        application.setSkills(dto.getSkills());

        application.setExperiences(dto.getExperiences());

        Application saved = applicationService.createApplication(application, jobId, user.get());

        return ResponseEntity.ok(saved);

    }





    @GetMapping
    public List<Application> getAllApplications() {
        return applicationService.getAllApplications();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Application> getApplicationById(@PathVariable UUID id) {
        Optional<Application> app = applicationService.getApplicationById(id);
        return app.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/user/{userId}")
    public List<Application> getApplicationByUserId(@PathVariable UUID userId) {
        return applicationService.getApplicationByUserId(userId);
    }

    @GetMapping("/job/{jobId}")
    public List<Application> getApplicationsByJobId(@PathVariable UUID jobId) {
        return applicationService.getApplicationsByJobId(jobId);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteApplication(@PathVariable UUID id) {
        applicationService.deleteApplication(id);
        return ResponseEntity.noContent().build();
    }
}

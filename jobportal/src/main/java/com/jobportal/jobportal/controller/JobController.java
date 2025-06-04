package com.jobportal.jobportal.controller;

import com.jobportal.jobportal.dto.JobRequestDTO;
import com.jobportal.jobportal.enums.Role;
import com.jobportal.jobportal.model.Job;
import com.jobportal.jobportal.model.User;
import com.jobportal.jobportal.repository.UserRepository;
import com.jobportal.jobportal.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("v1/jobs")
public class JobController {

    @Autowired
    private JobService jobService;

    @Autowired
    private UserRepository userRepository;
    @PostMapping
    public ResponseEntity<?> createJob(@RequestBody JobRequestDTO dto) {
        Optional<User> recruiter = userRepository.findById(dto.getRecruiterId());
        if (recruiter.isEmpty() || recruiter.get().getRole() != Role.RECRUITER) {
            return ResponseEntity.badRequest().body("Créateur non valide ou non recruteur");
        }

        Job job = new Job();
        job.setTitle(dto.getTitle());
        job.setDescription(dto.getDescription());
        job.setLocation(dto.getLocation());
        job.setType(dto.getType());
        job.setSalaryMin(dto.getSalaryMin());
        job.setSalaryMax(dto.getSalaryMax());
        job.setExperienceLevel(dto.getExperienceLevel());
        job.setCreatedBy(recruiter.get());

        return ResponseEntity.ok(jobService.createJob(job));
    }


    @GetMapping
    public List<Job> getAllJobs() {
        return jobService.getAllJobs();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable UUID id) {
        Optional<Job> job = jobService.getJobById(id);
        return job.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJob(@PathVariable UUID id) {
        jobService.deleteJob(id);
        return ResponseEntity.noContent().build();
    }

    // 🔎 Filtres
    @GetMapping("/search/location")
    public List<Job> searchByLocation(@RequestParam String location) {
        return jobService.searchByLocation(location);
    }

    @GetMapping("/search/type")
    public List<Job> searchByType(@RequestParam String type) {
        return jobService.searchByType(type);
    }

    @GetMapping("/search/title")
    public List<Job> searchByTitle(@RequestParam String title) {
        return jobService.searchByTitle(title);
    }
}

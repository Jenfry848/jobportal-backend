package com.jobportal.jobportal.model;

import com.jobportal.jobportal.enums.ApplicationStatus;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "applications", uniqueConstraints = {@UniqueConstraint(columnNames = {"user_id","job_id"})})
public class Application {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "job_id")
    private Job job;

    private LocalDate dateApplied;
    private String coverLetter;
    private String skills;
    private String experiences;

    @Enumerated(EnumType.STRING)
    private ApplicationStatus status;

    //  Constructeur par défaut
    public Application() {
        this.dateApplied = LocalDate.now();
        this.status = ApplicationStatus.PENDING;
    }

    // 🔧 Getters et Setters

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public LocalDate getDateApplied() {
        return dateApplied;
    }

    public void setDateApplied(LocalDate dateApplied) {
        this.dateApplied = dateApplied;
    }

    public String getCoverLetter() {
        return coverLetter;
    }

    public void setCoverLetter(String coverLetter) {
        this.coverLetter = coverLetter;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String resumeText) {
        this.skills = resumeText;
    }
    
    public String getExperiences() {
        return experiences;
    }

    public void setExperiences(String experiences) {
        this.experiences = experiences;
    }

    public ApplicationStatus getStatus() {
        return status;
    }

    public void setStatus(ApplicationStatus status) {
        this.status = status;
    }
}
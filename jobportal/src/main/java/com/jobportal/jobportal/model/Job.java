package com.jobportal.jobportal.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.UUID;
import java.util.List;
import java.util.ArrayList;

@Entity
@Table(name = "jobs")
public class Job {

    @Id
    @GeneratedValue
    private UUID id;

    private String title;
    private String description;
    private String location;
    private String type;         // ex: full-time, part-time, freelance
    private Integer salaryMin;
    private Integer salaryMax;
    private String experienceLevel;
    private LocalDate postedDate;

    @ManyToOne
    @JoinColumn(name = "created_by")
    private User createdBy;

    @OneToMany(mappedBy = "job")
    private List<Application> applications;

    // ✅ Constructeur par défaut
    public Job() {
        this.postedDate = LocalDate.now();
        this.applications = new ArrayList<>();
    }

    // ✅ Constructeur complet
    public Job(String title, String description, String location, String type,
               Integer salaryMin, Integer salaryMax, String experienceLevel) {
        this.title = title;
        this.description = description;
        this.location = location;
        this.type = type;
        this.salaryMin = salaryMin;
        this.salaryMax = salaryMax;
        this.experienceLevel = experienceLevel;
        this.postedDate = LocalDate.now();
        this.applications = new ArrayList<>();
    }

    // ✅ Getters et Setters

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getSalaryMin() {
        return salaryMin;
    }

    public void setSalaryMin(Integer salaryMin) {
        this.salaryMin = salaryMin;
    }

    public Integer getSalaryMax() {
        return salaryMax;
    }

    public void setSalaryMax(Integer salaryMax) {
        this.salaryMax = salaryMax;
    }

    public String getExperienceLevel() {
        return experienceLevel;
    }

    public void setExperienceLevel(String experienceLevel) {
        this.experienceLevel = experienceLevel;
    }

    public LocalDate getPostedDate() {
        return postedDate;
    }

    public void setPostedDate(LocalDate postedDate) {
        this.postedDate = postedDate;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public List<Application> getApplications() {
        return applications;
    }

    public void setApplications(List<Application> applications) {
        this.applications = applications;
    }
}

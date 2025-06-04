package com.jobportal.jobportal.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.UUID;
import java.util.List;
import java.util.ArrayList;

@Entity
@Table(name = "jobs", uniqueConstraints = {@UniqueConstraint(columnNames = {"title", "location","company"})})
public class Job {

    @Id
    @GeneratedValue
    private UUID id;

    private String title;
    private String description;
    private String location;
    private String type;         // ex: full-time, part-time, freelance
    private Double salaryMin;
    private Double salaryMax;
    private String company;
    private String experienceLevel;
    private LocalDate postedDate;

    @ManyToOne
    @JoinColumn(name = "created_by")
    private User createdBy;

    @OneToMany(mappedBy = "job")
    @JsonIgnore
    private List<Application> applications;

    // ✅ Constructeur par défaut
    public Job() {
        this.postedDate = LocalDate.now();
        this.applications = new ArrayList<>();
    }

    // ✅ Constructeur complet
    public Job(String title, String description, String location, String type,
               Double salaryMin, Double salaryMax,String company, String experienceLevel) {
        this.title = title;
        this.description = description;
        this.location = location;
        this.type = type;
        this.salaryMin = salaryMin;
        this.salaryMax = salaryMax;
        this.company= company;
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

    public Double getSalaryMin() {
        return salaryMin;
    }

    public void setSalaryMin(Double salaryMin) {
        this.salaryMin = salaryMin;
    }

    public Double getSalaryMax() {
        return salaryMax;
    }

    public void setSalaryMax(Double salaryMax) {
        this.salaryMax = salaryMax;
    }

    public String getCompany(){
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
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

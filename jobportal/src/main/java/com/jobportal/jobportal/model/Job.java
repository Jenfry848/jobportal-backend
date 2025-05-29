package com.jobportal.jobportal.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "jobs")
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private String location;
    private String type;         // ex: full-time, part-time, freelance
    private String salaryRange;
    private String experienceLevel;
    private LocalDate postedDate;

    @ManyToOne
    @JoinColumn(name = "recruiter_id")
    private User recruiter;

    public Job() {
        this.postedDate = LocalDate.now();
    }

    public Job(String title, String description, String location, String type,
               String salaryRange, String experienceLevel) {
        this.title = title;
        this.description = description;
        this.location = location;
        this.type = type;
        this.salaryRange = salaryRange;
        this.experienceLevel = experienceLevel;
        this.postedDate = LocalDate.now();
    }

    // Getters and Setters

    public Long getId() {
        return id;
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

    public String getSalaryRange() {
        return salaryRange;
    }

    public void setSalaryRange(String salaryRange) {
        this.salaryRange = salaryRange;
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
}

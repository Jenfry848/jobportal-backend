package com.jobportal.jobportal.dto;

import java.util.UUID;

public class JobRequestDTO {

    private String title;
    private String description;
    private String location;
    private String type;
    private Double salaryMin;
    private Double salaryMax;
    private String experienceLevel;
    private UUID recruiterId;

    // Getters & Setters

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

    public String getExperienceLevel() {
        return experienceLevel;
    }
    public void setExperienceLevel(String experienceLevel) {
        this.experienceLevel = experienceLevel;
    }

    public UUID getRecruiterId() {
        return recruiterId;
    }
    public void setRecruiterId(UUID createdById) {
        this.recruiterId = createdById;
    }
}

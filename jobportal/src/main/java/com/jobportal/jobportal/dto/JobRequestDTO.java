package com.jobportal.jobportal.dto;

import java.util.UUID;

public class JobRequestDTO {

    private String title;
    private String description;
    private String location;
    private String type;
    private Integer salaryMin;
    private Integer salaryMax;
    private String experienceLevel;
    private UUID createdById;

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

    public UUID getCreatedById() {
        return createdById;
    }
    public void setCreatedById(UUID createdById) {
        this.createdById = createdById;
    }
}

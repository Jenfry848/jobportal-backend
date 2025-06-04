package com.jobportal.jobportal.dto;

import java.util.UUID;

public class ApplicationRequestDTO {

    public UUID userId;
    public String coverLetter;
    public String skills;
    public String experiences;

    public ApplicationRequestDTO() {
    }

    public ApplicationRequestDTO(UUID userId, String coverLetter, String skills, String expereinces) {
        this.userId = userId;
        this.coverLetter = coverLetter;
        this.skills = skills;
        this.experiences = experiences;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
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

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getExperiences() {
        return experiences;
    }

    public void setExperiences(String experiences) {
        this.experiences = experiences;
    }
}

package com.jobportal.jobportal.dto;

import java.util.UUID;

public class ApplicationRequestDTO {

    public UUID userId;
    public String coverLetter;
    public String resumeText;

    public ApplicationRequestDTO() {
    }

    public ApplicationRequestDTO(UUID userId, String coverLetter, String resumeText) {
        this.userId = userId;
        this.coverLetter = coverLetter;
        this.resumeText = resumeText;
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

    public String getResumeText() {
        return resumeText;
    }

    public void setResumeText(String resumeText) {
        this.resumeText = resumeText;
    }
}

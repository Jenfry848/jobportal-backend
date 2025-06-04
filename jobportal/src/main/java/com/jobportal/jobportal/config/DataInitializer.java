package com.jobportal.jobportal.config;

import com.jobportal.jobportal.enums.ApplicationStatus;

import com.jobportal.jobportal.enums.Role;

import com.jobportal.jobportal.model.Application;

import com.jobportal.jobportal.model.Job;

import com.jobportal.jobportal.model.User;

import com.jobportal.jobportal.repository.ApplicationRepository;

import com.jobportal.jobportal.repository.JobRepository;

import com.jobportal.jobportal.repository.UserRepository;

import jakarta.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component

public class DataInitializer {

    @Autowired

    private UserRepository userRepository;

    @Autowired

    private JobRepository jobRepository;

    @Autowired

    private ApplicationRepository applicationRepository;

    @PostConstruct

    public void initData() {

        // 👩🏽‍💼 Création d’un recruteur

        User recruiter = new User("Claire", "Martin", "claire@entreprise.com", "0611223344", Role.RECRUITER, "1234");

        userRepository.save(recruiter);

        // 👨🏾‍💻 Création d’un candidat

        User candidate = new User("Ali", "Traoré", "ali@gmail.com", "0699887766", Role.CANDIDATE, "0000");

        userRepository.save(candidate);

        // 🧠 Ajout d’une offre d’emploi

        Job job = new Job("Développeur Java", "Travail sur backend Spring Boot", "Lyon", "CDI", 35000.0, 45000.0, "Junior", "SNCF");

        job.setCompany("TechCorp");

        job.setCreatedBy(recruiter);

        jobRepository.save(job);

        // 📝 Ajout d’une candidature

        Application app = new Application();

        app.setUser(candidate);

        app.setJob(job);

        app.setSkills("Java, Spring, Git");

        app.setExperiences("Stage 6 mois chez Capgemini");

        app.setCoverLetter("Passionné par les projets backend Java.");

        app.setStatus(ApplicationStatus.PENDING);

        applicationRepository.save(app);

    }

}


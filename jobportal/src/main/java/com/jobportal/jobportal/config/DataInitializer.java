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
import java.util.Optional;

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

        // === USERS ===

        User recruiter1 = userRepository.findByEmail("claire@entreprise.com").orElseGet(() -> {

            User u = new User("Claire", "Martin", "claire@entreprise.com", "0611223344", Role.RECRUITER, "1234");

            return userRepository.save(u);

        });

        User candidate1 = userRepository.findByEmail("ali@gmail.com").orElseGet(() -> {

            User u = new User("Ali", "Traoré", "ali@gmail.com", "0699887766", Role.CANDIDATE, "5678");

            return userRepository.save(u);

        });

        // === JOBS ===

        Job job1 = jobRepository.findByTitle("Développeur Java").stream().findFirst().orElseGet(() -> {

            Job j = new Job("Développeur Java", "Développement backend avec Spring", "Lyon", "CDI", 35000.0, 45000.0, "SNCF", "Junior");

            j.setCompany("TechCorp");

            j.setCreatedBy(recruiter1);

            return jobRepository.save(j);

        });

        Job job2 = jobRepository.findByTitle("UX Designer").stream().findFirst().orElseGet(() -> {

            Job j = new Job("UX Designer", "Design d'interfaces intuitives", "Paris", "Freelance", 30000.0, 40000.0, "Orange","senior");

            j.setCompany("UXify");

            j.setCreatedBy(recruiter1);

            return jobRepository.save(j);

        });

        // === APPLICATIONS ===

        if (applicationRepository.findAll().isEmpty()) {

            Application app1 = new Application();

            app1.setUser(candidate1);

            app1.setJob(job1);

            app1.setSkills("Java, Spring, Git");

            app1.setExperiences("Stage 6 mois chez Capgemini");

            app1.setCoverLetter("Motivé par le développement backend");

            app1.setStatus(ApplicationStatus.PENDING);

            applicationRepository.save(app1);

            Application app2 = new Application();

            app2.setUser(candidate1);

            app2.setJob(job2);

            app2.setSkills("Figma, Sketch, UX Writing");

            app2.setExperiences("Freelance 2 ans en design web");

            app2.setCoverLetter("Expérience solide en UX design");

            app2.setStatus(ApplicationStatus.PENDING);

            applicationRepository.save(app2);

        }

    }

}


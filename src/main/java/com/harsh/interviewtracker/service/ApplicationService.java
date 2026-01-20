package com.harsh.interviewtracker.service;

import com.harsh.interviewtracker.entity.Application;
import com.harsh.interviewtracker.entity.ApplicationStatus;
import com.harsh.interviewtracker.repository.ApplicationRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ApplicationService {
    private final ApplicationRepository applicationRepository;
    public ApplicationService(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }
    // Create new application
    public Application createApplication(Application application) {
        application.setStatus(ApplicationStatus.APPLIED);
        application.setCreatedAt(LocalDateTime.now());
        return applicationRepository.save(application);
    }

    // Fetch all applications
    public List<Application> getAllApplications() {
        return applicationRepository.findAll();
    }
}

package com.harsh.interviewtracker.controller;

import com.harsh.interviewtracker.entity.Application;
import com.harsh.interviewtracker.service.ApplicationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/applications")
public class ApplicationController {

    private final ApplicationService applicationService;

    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    // ➕ Create Application
    @PostMapping
    public Application createApplication(@RequestBody Application application) {
        return applicationService.createApplication(application);
    }

    // 📄 Get All Applications
    @GetMapping
    public List<Application> getAllApplications() {
        return applicationService.getAllApplications();
    }

    // 🔍 Runtime validation endpoint
    @GetMapping("/version")
    public Map<String, String> version() {
        return Map.of(
                "name", "Interview Tracker API",
                "version", "1.0.0"
        );
    }
}

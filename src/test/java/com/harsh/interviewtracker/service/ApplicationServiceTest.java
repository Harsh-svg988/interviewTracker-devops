package com.harsh.interviewtracker.service;

import com.harsh.interviewtracker.entity.Application;
import com.harsh.interviewtracker.entity.ApplicationStatus;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ApplicationServiceTest {

    @Autowired
    private ApplicationService applicationService;

    @Test
    void whenCreateApplication_thenDefaultsAreSet() {
        // given
        Application application = new Application();
        application.setCompanyName("Google");
        application.setRole("Backend Engineer");

        // when
        Application saved = applicationService.createApplication(application);

        // then
        assertNotNull(saved.getId());
        assertEquals("Google", saved.getCompanyName());
        assertEquals("Backend Engineer", saved.getRole());
        assertEquals(ApplicationStatus.APPLIED, saved.getStatus());
        assertNotNull(saved.getCreatedAt());
    }
}

package com.harsh.interviewtracker.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.harsh.interviewtracker.entity.Application;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class ApplicationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void postApplication_shouldReturnOk() throws Exception {
        Application application = new Application();
        application.setCompanyName("Amazon");
        application.setRole("Backend Engineer");

        mockMvc.perform(post("/applications")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(application)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.companyName").value("Amazon"))
                .andExpect(jsonPath("$.role").value("Backend Engineer"))
                .andExpect(jsonPath("$.status").value("APPLIED"));
    }

    @Test
    void getApplications_shouldReturnList() throws Exception {
        mockMvc.perform(get("/applications"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }
}

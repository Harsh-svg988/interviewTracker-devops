package com.harsh.interviewtracker.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
@Entity

public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String companyName;
    private String role;

    @Enumerated(EnumType.STRING)
    private ApplicationStatus status;

    private LocalDateTime createdAt;

    // setters
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setStatus(ApplicationStatus status) {
        this.status = status;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    // getters
    public Long getId() {
        return id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getRole() {
        return role;
    }

    public ApplicationStatus getStatus() {
        return status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

}

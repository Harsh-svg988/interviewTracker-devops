package com.harsh.interviewtracker.repository;

import com.harsh.interviewtracker.entity.Application;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationRepository extends JpaRepository<Application, Long> {
}

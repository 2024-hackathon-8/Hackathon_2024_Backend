package com.example.hackathon_2024.domain.business.repository;

import com.example.hackathon_2024.domain.business.entity.Business;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusinessRepository extends JpaRepository<Business, Long> {
}

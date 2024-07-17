package com.example.hackathon_2024.domain.business.repository;

import com.example.hackathon_2024.domain.business.entity.Business;
import com.example.hackathon_2024.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BusinessRepository extends JpaRepository<Business, Long> {
    List<Business> findAllByUser(User user);
}

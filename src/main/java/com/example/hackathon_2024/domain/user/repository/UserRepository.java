package com.example.hackathon_2024.domain.user.repository;

import com.example.hackathon_2024.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findByAccountId(String accountId);
}
package com.example.hackathon_2024.domain.user.repository;

import com.example.hackathon_2024.domain.user.entity.User;
import com.example.hackathon_2024.domain.user.entity.UserTag;
import com.example.hackathon_2024.domain.user.entity.UserTagId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserTagRepository extends JpaRepository<UserTag, UserTagId> {
    List<UserTag> findAllByUserId(User user);
}

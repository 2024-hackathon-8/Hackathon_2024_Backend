package com.example.hackathon_2024.domain.alarm.repository;

import com.example.hackathon_2024.domain.alarm.entity.Alarm;
import com.example.hackathon_2024.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlarmRepository extends JpaRepository<Alarm, Long> {
    List<Alarm> findAllByRecipientId(User user);
}

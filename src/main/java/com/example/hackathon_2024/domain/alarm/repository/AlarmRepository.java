package com.example.hackathon_2024.domain.alarm.repository;

import com.example.hackathon_2024.domain.alarm.entity.Alarm;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlarmRepository extends JpaRepository<Alarm, Long> {
}

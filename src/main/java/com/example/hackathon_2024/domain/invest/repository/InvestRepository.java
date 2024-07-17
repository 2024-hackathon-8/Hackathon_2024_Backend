package com.example.hackathon_2024.domain.invest.repository;

import com.example.hackathon_2024.domain.invest.entity.Invest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvestRepository extends JpaRepository<Invest, Long> {
}
package com.example.hackathon_2024.domain.repayment.repository;

import com.example.hackathon_2024.domain.repayment.entity.Repayment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepaymentRepository extends JpaRepository<Repayment, Long> {
}
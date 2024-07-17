package com.example.hackathon_2024.domain.repayment.repository;

import com.example.hackathon_2024.domain.invest.entity.Invest;
import com.example.hackathon_2024.domain.repayment.entity.Repayment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RepaymentRepository extends JpaRepository<Repayment, Long> {
    List<Repayment> findAllByInvest(Invest invest);
}
package com.example.hackathon_2024.domain.contract.repository;

import com.example.hackathon_2024.domain.contract.entity.Contract;
import com.example.hackathon_2024.domain.invest.entity.Invest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractRepository extends JpaRepository<Contract, Long> {
    Contract findByInvest(Invest invest);
}
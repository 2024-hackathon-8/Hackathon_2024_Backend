package com.example.hackathon_2024.domain.invest.repository;

import com.example.hackathon_2024.domain.business.entity.Business;
import com.example.hackathon_2024.domain.invest.entity.Invest;
import com.example.hackathon_2024.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InvestRepository extends JpaRepository<Invest, Long> {
    List<Invest> findAllByUser(User user);
    List<Invest> findAllByBusiness(Business business);
}
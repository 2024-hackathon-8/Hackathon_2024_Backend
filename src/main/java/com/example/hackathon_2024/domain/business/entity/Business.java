package com.example.hackathon_2024.domain.business.entity;

import com.example.hackathon_2024.domain.user.entity.User;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class Business {

    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "business_name", nullable = false)
    private String businessName;

    @Column(name = "one_liner", nullable = false)
    private String oneLiner;

    @Column(name = "business_introduce", nullable = false)
    private String businessIntroduce;

    @Column(name = "vision", nullable = false)
    private String vision;

    @Column(name = "write_purpose")
    private String writePurpose;

    @Column(name = "total_investment")
    private Long totalInvestment;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private User user;
}

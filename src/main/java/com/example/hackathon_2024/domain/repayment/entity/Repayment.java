package com.example.hackathon_2024.domain.repayment.entity;

import com.example.hackathon_2024.domain.invest.entity.Invest;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Repayment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "repayment_money", nullable = false)
    private Long repaymentMoney;

    @Column(name = "repayment_date", nullable = false)
    private LocalDate repaymentDate;

    @ManyToOne
    @JoinColumn(name = "invest_id")
    private Invest invest;
}

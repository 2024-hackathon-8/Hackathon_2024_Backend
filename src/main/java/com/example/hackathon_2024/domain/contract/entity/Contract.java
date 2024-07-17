package com.example.hackathon_2024.domain.contract.entity;

import com.example.hackathon_2024.domain.invest.entity.Invest;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "invest_id")
    private Invest invest;

    @Column(name = "funder_name", nullable = false)
    private String funderName;

    @Column(name = "funded_name", nullable = false)
    private String fundedName;

    @Column(name = "prefer_contract_period", nullable = false)
    private LocalDate preferContractPeriod;

    @Column(name = "final_contract_period", nullable = false)
    private LocalDate finalContractPeriod;

    @Column(name = "contract_money", nullable = false)
    private Long contractMoney;

    @Column(name = "business_name", nullable = false)
    private String businessName;

    @Column(name = "sales_ratio", nullable = false)
    private double salesRatio;

    @Column(name = "sales_days", nullable = false)
    private Integer salesDays;

    @Column(name = "repayment_delay_day", nullable = false)
    private Integer repaymentDelayDay;

    @Column(name = "overdue_quarter", nullable = false)
    private Integer overdueQuarter;

    @Column(name = "overdue_ratio", nullable = false)
    private double overdueRatio;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> specialMatter;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "representative_name", nullable = false)
    private String representativeName;

    @Column(name = "representative_phone_number", nullable = false)
    private String representativePhoneNumber;

    @Column(name = "signature_img_url", nullable = false)
    private String signatureImgUrl;
}

package com.example.hackathon_2024.domain.repayment.dto.request;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class RepaymentRequest {

    private Long repayment_money;

    private LocalDate repayment_date;
}

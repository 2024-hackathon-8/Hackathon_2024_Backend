package com.example.hackathon_2024.domain.contract.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
@AllArgsConstructor
public class ContractWritePageResponse {

    private Long invest_id;

    private String funder_name;

    private String funded_name;

    private String business_name;

    private LocalDate prefer_contract_period;

    private String representative_name;

    private String representative_phone_number;
}
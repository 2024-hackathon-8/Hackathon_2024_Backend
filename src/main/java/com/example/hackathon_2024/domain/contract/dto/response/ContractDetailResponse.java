package com.example.hackathon_2024.domain.contract.dto.response;

import com.example.hackathon_2024.domain.repayment.dto.response.RepaymentResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class ContractDetailResponse {

    private String funder_name;

    private String funded_name;

    private LocalDate prefer_contract_period;

    private LocalDate final_contract_period;

    private List<RepaymentResponse> repaymentResponses;

    private Long contract_money;

    private String business_name;

    private double sales_ratio;

    private Integer sales_days;

    private Integer repayment_delay_day;

    private Integer overdue_quarter;

    private double overdue_ratio;

    private List<String> special_matter;

    private String address;

    private String representative_name;

    private String representative_phone_number;

    private String signature_img_url;
}


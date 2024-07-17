package com.example.hackathon_2024.domain.contract.dto.request;

import com.example.hackathon_2024.domain.repayment.dto.request.RepaymentRequest;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Builder
public class ContractRequest {

    @NotNull
    private Long invest_id;

    @NotNull
    private LocalDate final_contract_period;

    @NotNull
    private List<RepaymentRequest> repayments;

    @NotNull
    private double sales_ratio;

    @NotNull
    private Integer sales_days;

    @NotNull
    private Integer repayment_delay_day;

    @NotNull
    private Integer overdue_quarter;

    @NotNull
    private double overdue_ratio;

    @NotNull
    private List<String> special_matter;

    @NotBlank
    private String address;

    @NotBlank
    private String signature_img_url;
}

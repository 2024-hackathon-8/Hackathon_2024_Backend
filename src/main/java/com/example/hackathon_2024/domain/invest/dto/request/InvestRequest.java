package com.example.hackathon_2024.domain.invest.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class InvestRequest {

    @NotBlank
    private Long business_id;

    @NotBlank
    private String phone_number;

    @NotNull
    private LocalDate invest_period;

    @NotNull
    private Long money;
}

package com.example.hackathon_2024.domain.business.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class BusinessRequest {

    @NotBlank
    private String businessName;

    @NotBlank
    private String oneLiner;

    @NotBlank
    private String businessIntroduce;

    @NotBlank
    private String vision;

    @NotNull
    private Long totalInvestment;

    private List<String> tag_name;
}
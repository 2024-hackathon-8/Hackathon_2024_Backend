package com.example.hackathon_2024.domain.business.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class BusinessRequest {

    @NotBlank
    private String business_name;

    @NotBlank
    private String one_liner;

    @NotBlank
    private String business_introduce;

    @NotBlank
    private String vision;

    @NotNull
    private Long total_investment;

    private List<String> tags;
}
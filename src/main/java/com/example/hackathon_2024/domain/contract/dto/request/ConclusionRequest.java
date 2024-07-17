package com.example.hackathon_2024.domain.contract.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class ConclusionRequest {

    private Long invest_id;

    @NotBlank
    private String address;

    @NotBlank
    private String signature_img_url;
}

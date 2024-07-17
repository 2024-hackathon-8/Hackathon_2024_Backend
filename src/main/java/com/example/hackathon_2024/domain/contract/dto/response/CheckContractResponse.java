package com.example.hackathon_2024.domain.contract.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class CheckContractResponse {

    private String representative_name;

    private String phone_number;
}

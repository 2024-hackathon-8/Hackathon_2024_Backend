package com.example.hackathon_2024.domain.auth.dto.request;

import lombok.Getter;

@Getter
public class VerifyRequest {

    private String phone_number;

    private String random_number;
}

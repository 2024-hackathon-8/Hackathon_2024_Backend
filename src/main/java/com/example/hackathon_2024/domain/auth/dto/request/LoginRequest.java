package com.example.hackathon_2024.domain.auth.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class LoginRequest {

    @NotBlank
    private String account_id;

    @NotBlank
    private String password;
}

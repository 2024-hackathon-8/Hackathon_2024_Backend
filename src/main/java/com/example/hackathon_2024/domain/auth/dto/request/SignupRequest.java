package com.example.hackathon_2024.domain.auth.dto.request;

import com.example.hackathon_2024.domain.user.entity.enums.UserType;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

import java.util.List;

@Getter
public class SignupRequest {

    @NotBlank
    private String accountId;

    @NotBlank
    private String password;

    @NotBlank
    private String name;

    @NotBlank
    private UserType userType;

    private List<String> tagName;
}

package com.example.hackathon_2024.domain.auth.dto.request;

import com.example.hackathon_2024.domain.user.entity.enums.UserType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.util.List;

@Getter
public class SignupRequest {

    @NotBlank
    private String account_id;

    @NotBlank
    private String password;

    @NotBlank
    private String name;

    @NotNull
    private UserType user_type;

    private List<String> tag_name;
}

package com.example.hackathon_2024.domain.auth.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Getter
@Builder
public class TokenResponse {

    private String access_token;

    private String refresh_token;

    private Date access_expired_at;

    private Date refresh_expired_at;
}

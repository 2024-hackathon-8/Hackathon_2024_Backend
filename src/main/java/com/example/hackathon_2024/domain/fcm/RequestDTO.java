package com.example.hackathon_2024.domain.fcm;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestDTO {
    private String targetToken;
    private String title;
    private String body;
}

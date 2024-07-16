package com.example.hackathon_2024.domain.user.entity.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum UserType {

    PERSONAL("개인"),

    COMPANY("회사");

    private final String name;
}

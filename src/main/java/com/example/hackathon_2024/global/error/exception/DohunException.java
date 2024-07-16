package com.example.hackathon_2024.global.error.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DohunException extends RuntimeException {
    private final ErrorCode errorCode;
}

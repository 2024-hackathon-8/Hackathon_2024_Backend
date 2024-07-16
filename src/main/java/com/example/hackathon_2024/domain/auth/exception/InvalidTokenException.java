package com.example.hackathon_2024.domain.auth.exception;

import com.example.hackathon_2024.global.error.exception.DohunException;
import com.example.hackathon_2024.global.error.exception.ErrorCode;

public class InvalidTokenException extends DohunException {

    public static final DohunException EXCEPTION = new InvalidTokenException();

    public InvalidTokenException() {
        super(ErrorCode.INVALID_TOKEN);
    }
}
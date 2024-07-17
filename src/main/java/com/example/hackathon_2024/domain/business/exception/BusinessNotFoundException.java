package com.example.hackathon_2024.domain.business.exception;

import com.example.hackathon_2024.global.error.exception.DohunException;
import com.example.hackathon_2024.global.error.exception.ErrorCode;

public class BusinessNotFoundException extends DohunException {

    public static final DohunException EXCEPTION = new BusinessNotFoundException();

    public BusinessNotFoundException() {
        super(ErrorCode.BUSINESS_NOT_FOUND);
    }
}
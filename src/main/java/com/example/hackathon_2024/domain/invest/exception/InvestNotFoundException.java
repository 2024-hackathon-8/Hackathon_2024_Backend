package com.example.hackathon_2024.domain.invest.exception;

import com.example.hackathon_2024.global.error.exception.DohunException;
import com.example.hackathon_2024.global.error.exception.ErrorCode;

public class InvestNotFoundException extends DohunException {

    public static final DohunException EXCEPTION = new InvestNotFoundException();

    public InvestNotFoundException() {
        super(ErrorCode.USER_NOT_FOUND);
    }
}
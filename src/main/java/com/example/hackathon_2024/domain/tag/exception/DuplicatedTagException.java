package com.example.hackathon_2024.domain.tag.exception;

import com.example.hackathon_2024.global.error.exception.DohunException;
import com.example.hackathon_2024.global.error.exception.ErrorCode;

public class DuplicatedTagException extends DohunException {

    public static final DohunException EXCEPTION = new DuplicatedTagException();

    public DuplicatedTagException() {
        super(ErrorCode.DUPLICATED_TAG);
    }
}

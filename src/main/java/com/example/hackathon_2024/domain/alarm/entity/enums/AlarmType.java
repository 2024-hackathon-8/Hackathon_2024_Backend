package com.example.hackathon_2024.domain.alarm.entity.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum AlarmType {

    INVESTMENT_REQUEST("투자 요청"),

    DEPOSIT_CHECK("입금 확인"),

    CONTRACT_CHECK("계약서 확인"),

    CONTRACT_CONCLUSION("계약 체결");

    private final String name;
}
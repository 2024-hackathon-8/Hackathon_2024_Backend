package com.example.hackathon_2024.domain.invest.entity.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum InvestType {

    CONTRACT_SUCCESS("체결"),

    CONTRACT_WRITING("작성중"),

    CONTRACT_CHECK("확인"),

    CONTRACT_FAIL("불발");

    private final String name;
}
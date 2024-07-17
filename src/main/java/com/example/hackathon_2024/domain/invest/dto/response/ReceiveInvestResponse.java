package com.example.hackathon_2024.domain.invest.dto.response;

import com.example.hackathon_2024.domain.invest.entity.Invest;
import com.example.hackathon_2024.domain.invest.entity.enums.InvestType;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ReceiveInvestResponse {

    private Long investId;

    private String sender_name;

    private Long invest_money;

    private InvestType invest_type;

    public ReceiveInvestResponse(Invest invest) {
        this.investId = invest.getId();
        this.sender_name = invest.getUser().getName();
        this.invest_money = invest.getMoney();
        this.invest_type = invest.getInvestType();
    }
}

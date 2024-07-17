package com.example.hackathon_2024.domain.invest.dto.response;

import com.example.hackathon_2024.domain.invest.entity.Invest;
import com.example.hackathon_2024.domain.invest.entity.enums.InvestType;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class InvestmentResponse {

    private String business_name;

    private Long invest_money;

    private InvestType investType;

    public InvestmentResponse(Invest invest) {
        this.business_name = invest.getBusiness().getBusinessName();
        this.invest_money = invest.getMoney();
        investType = invest.getInvestType();
    }
}

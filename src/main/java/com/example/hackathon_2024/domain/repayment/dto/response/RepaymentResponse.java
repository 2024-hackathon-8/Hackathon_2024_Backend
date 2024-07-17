package com.example.hackathon_2024.domain.repayment.dto.response;

import com.example.hackathon_2024.domain.repayment.entity.Repayment;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class RepaymentResponse {

    private Long repayment_money;

    private LocalDate repayment_date;

    public RepaymentResponse(Repayment repayment) {
        this.repayment_money = repayment.getRepaymentMoney();
        this.repayment_date = repayment.getRepaymentDate();
    }
}

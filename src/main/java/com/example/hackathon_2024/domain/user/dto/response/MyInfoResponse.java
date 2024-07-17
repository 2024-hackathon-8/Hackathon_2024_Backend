package com.example.hackathon_2024.domain.user.dto.response;

import com.example.hackathon_2024.domain.invest.dto.response.InvestmentResponse;
import com.example.hackathon_2024.domain.invest.dto.response.ReceiveInvestResponse;
import com.example.hackathon_2024.domain.tag.entity.Tag;
import com.example.hackathon_2024.domain.user.entity.enums.UserType;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class MyInfoResponse {

    private String account_id;

    private String name;

    private UserType user_type;

    private String phone_number;

    private List<Tag> tags;

    private Long my_amount;

    private List<ReceiveInvestResponse> receive_invest;

    private List<InvestmentResponse> my_investment;
}

package com.example.hackathon_2024.domain.invest.service;

import com.example.hackathon_2024.domain.alarm.dto.AlarmRequest;
import com.example.hackathon_2024.domain.alarm.entity.enums.AlarmType;
import com.example.hackathon_2024.domain.alarm.service.CreateAlarmService;
import com.example.hackathon_2024.domain.business.entity.Business;
import com.example.hackathon_2024.domain.business.exception.BusinessNotFoundException;
import com.example.hackathon_2024.domain.business.repository.BusinessRepository;
import com.example.hackathon_2024.domain.invest.dto.request.InvestRequest;
import com.example.hackathon_2024.domain.invest.entity.Invest;
import com.example.hackathon_2024.domain.invest.entity.enums.InvestType;
import com.example.hackathon_2024.domain.invest.repository.InvestRepository;
import com.example.hackathon_2024.domain.user.entity.User;
import com.example.hackathon_2024.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class RequestInvestService {

    private final InvestRepository investRepository;

    private final CreateAlarmService createAlarmService;

    private final UserFacade userFacade;

    private final BusinessRepository businessRepository;

    @Transactional
    public void requestInvest(InvestRequest request) {

        Business business = businessRepository.findById(request.getBusiness_id())
                        .orElseThrow(()-> BusinessNotFoundException.EXCEPTION);

        User user = userFacade.currentUser();

        investRepository.save(
                Invest.builder()
                        .phoneNumber(request.getPhone_number())
                        .preferContractPeriod(request.getPrefer_invest_period())
                        .money(request.getMoney())
                        .business(business)
                        .investType(InvestType.CONTRACT_WRITING)
                        .user(user)
                        .build());

        createAlarmService.crateAlarm(
                AlarmRequest.builder()
                        .alarm_type(AlarmType.INVESTMENT_REQUEST)
                        .sender_name(user.getName())
                        .recipient_account_id(business.getUser().getAccountId())
                        .money(request.getMoney())
                        .send_time(LocalDate.now())
                        .build()
        );
    }
}

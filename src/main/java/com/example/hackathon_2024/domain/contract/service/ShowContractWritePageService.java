package com.example.hackathon_2024.domain.contract.service;

import com.example.hackathon_2024.domain.contract.dto.response.ContractWritePageResponse;
import com.example.hackathon_2024.domain.invest.entity.Invest;
import com.example.hackathon_2024.domain.invest.exception.InvestNotFoundException;
import com.example.hackathon_2024.domain.invest.repository.InvestRepository;
import com.example.hackathon_2024.domain.user.entity.User;
import com.example.hackathon_2024.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ShowContractWritePageService {

    private final InvestRepository investRepository;

    private final UserFacade userFacade;

    public ContractWritePageResponse showContractWritePage(Long investId) {
        Invest invest = getInvest(investId);
        User user = userFacade.currentUser();
        return createContractWritePageResponse(invest, user);
    }

    private Invest getInvest(Long investId) {
        return investRepository.findById(investId)
                .orElseThrow(() -> InvestNotFoundException.EXCEPTION);
    }

    private ContractWritePageResponse createContractWritePageResponse(Invest invest, User user) {
        return ContractWritePageResponse.builder()
                .invest_id(invest.getId())
                .funder_name(invest.getUser().getName())
                .funded_name(invest.getBusiness().getUser().getName())
                .business_name(invest.getBusiness().getBusinessName())
                .prefer_contract_period(invest.getPreferContractPeriod())
                .representative_name(user.getName())
                .representative_phone_number(user.getPhoneNumber())
                .build();
    }
}
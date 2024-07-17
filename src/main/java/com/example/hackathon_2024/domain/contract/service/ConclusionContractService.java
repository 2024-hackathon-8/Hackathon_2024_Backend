package com.example.hackathon_2024.domain.contract.service;

import com.example.hackathon_2024.domain.contract.dto.request.ConclusionRequest;
import com.example.hackathon_2024.domain.contract.entity.Contract;
import com.example.hackathon_2024.domain.contract.repository.ContractRepository;
import com.example.hackathon_2024.domain.invest.entity.Invest;
import com.example.hackathon_2024.domain.invest.entity.enums.InvestType;
import com.example.hackathon_2024.domain.invest.exception.InvestNotFoundException;
import com.example.hackathon_2024.domain.invest.repository.InvestRepository;
import com.example.hackathon_2024.domain.user.entity.User;
import com.example.hackathon_2024.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ConclusionContractService {

    private final UserFacade userFacade;

    private final InvestRepository investRepository;

    private final ContractRepository contractRepository;

    @Transactional
    public void conclusionContract(ConclusionRequest request) {

        User user = userFacade.currentUser();

        Invest invest = investRepository.findById(request.getInvest_id())
                .orElseThrow(()-> InvestNotFoundException.EXCEPTION);

        Contract contract = contractRepository.findByInvest(invest);

        contract.conclusionContract(request.getAddress(), user.getName(), user.getPhoneNumber(), request.getSignature_img_url());
        invest.changeInvestType(InvestType.CONTRACT_SUCCESS);
        invest.getBusiness().updateTotalInvestment(invest.getMoney());
    }
}

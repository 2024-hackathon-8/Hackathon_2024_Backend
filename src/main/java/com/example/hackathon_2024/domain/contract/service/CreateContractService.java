package com.example.hackathon_2024.domain.contract.service;

import com.example.hackathon_2024.domain.contract.dto.request.ContractRequest;
import com.example.hackathon_2024.domain.contract.entity.Contract;
import com.example.hackathon_2024.domain.contract.repository.ContractRepository;
import com.example.hackathon_2024.domain.invest.entity.Invest;
import com.example.hackathon_2024.domain.invest.entity.enums.InvestType;
import com.example.hackathon_2024.domain.invest.exception.InvestNotFoundException;
import com.example.hackathon_2024.domain.invest.repository.InvestRepository;
import com.example.hackathon_2024.domain.repayment.dto.request.RepaymentRequest;
import com.example.hackathon_2024.domain.repayment.entity.Repayment;
import com.example.hackathon_2024.domain.repayment.repository.RepaymentRepository;
import com.example.hackathon_2024.domain.user.entity.User;
import com.example.hackathon_2024.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CreateContractService {

    private final UserFacade userFacade;

    private final InvestRepository investRepository;

    private final ContractRepository contractRepository;

    private final RepaymentRepository repaymentRepository;

    @Transactional
    public void createContract(ContractRequest request) {
        User user = userFacade.currentUser();
        Invest invest = getInvest(request.getInvest_id());
        Contract contract = createContract(invest, request, user);
        List<Repayment> repayments = createRepayments(request.getRepayments(), invest);

        contractRepository.save(contract);
        repaymentRepository.saveAll(repayments);
        writeContract(invest);
    }

    private Invest getInvest(Long investId) {
        return investRepository.findById(investId)
                .orElseThrow(() -> InvestNotFoundException.EXCEPTION);
    }

    private Contract createContract(Invest invest, ContractRequest request, User user) {
        return Contract.builder()
                .invest(invest)
                .funderName(invest.getUser().getName())
                .fundedName(invest.getBusiness().getUser().getName())
                .preferContractPeriod(invest.getPreferContractPeriod())
                .finalContractPeriod(request.getFinal_contract_period())
                .contractMoney(invest.getMoney())
                .businessName(invest.getBusiness().getBusinessName())
                .salesRatio(request.getSales_ratio())
                .salesDays(request.getSales_days())
                .repaymentDelayDay(request.getRepayment_delay_day())
                .overdueQuarter(request.getOverdue_quarter())
                .overdueRatio(request.getOverdue_ratio())
                .specialMatter(request.getSpecial_matter())
                .addressA(request.getAddress())
                .representativeNameA(user.getName())
                .representativePhoneNumberA(user.getPhoneNumber())
                .signatureImgUrlA(request.getSignature_img_url())
                .build();
    }

    private List<Repayment> createRepayments(List<RepaymentRequest> repaymentRequests, Invest invest) {
        return repaymentRequests.stream()
                .map(r -> new Repayment(r, invest))
                .collect(Collectors.toList());
    }

    private void writeContract(Invest invest) {
        invest.changeInvestType(InvestType.CONTRACT_CHECK);
    }
}

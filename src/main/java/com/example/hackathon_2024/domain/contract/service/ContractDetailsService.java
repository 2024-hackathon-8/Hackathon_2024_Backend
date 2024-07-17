package com.example.hackathon_2024.domain.contract.service;

import com.example.hackathon_2024.domain.contract.dto.response.ContractDetailResponse;
import com.example.hackathon_2024.domain.contract.entity.Contract;
import com.example.hackathon_2024.domain.contract.repository.ContractRepository;
import com.example.hackathon_2024.domain.invest.entity.Invest;
import com.example.hackathon_2024.domain.invest.exception.InvestNotFoundException;
import com.example.hackathon_2024.domain.invest.repository.InvestRepository;
import com.example.hackathon_2024.domain.repayment.dto.response.RepaymentResponse;
import com.example.hackathon_2024.domain.repayment.repository.RepaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ContractDetailsService {

    private final InvestRepository investRepository;

    private final ContractRepository contractRepository;

    private final RepaymentRepository repaymentRepository;;

    public ContractDetailResponse contractDetail(Long investId) {
        Invest invest = investRepository.findById(investId)
                .orElseThrow(()-> InvestNotFoundException.EXCEPTION);

        Contract contract = contractRepository.findByInvest(invest);

        return ContractDetailResponse.builder()
                .funder_name(contract.getFunderName())
                .funded_name(contract.getFundedName())
                .prefer_contract_period(contract.getPreferContractPeriod())
                .final_contract_period(contract.getFinalContractPeriod())
                .repaymentResponses(repaymentRepository.findAllByInvest(invest).stream().map(RepaymentResponse::new).toList())
                .contract_money(contract.getContractMoney())
                .business_name(contract.getBusinessName())
                .sales_ratio(contract.getSalesRatio())
                .sales_days(contract.getSalesDays())
                .repayment_delay_day(contract.getRepaymentDelayDay())
                .overdue_quarter(contract.getOverdueQuarter())
                .overdue_ratio(contract.getOverdueRatio())
                .special_matter(contract.getSpecialMatter())
                .address(contract.getAddress())
                .representative_name(contract.getRepresentativeName())
                .representative_phone_number(contract.getRepresentativePhoneNumber())
                .signature_img_url(contract.getSignatureImgUrl())
                .build();
    }
}
package com.example.hackathon_2024.domain.contract.controller;

import com.example.hackathon_2024.domain.contract.dto.request.ConclusionRequest;
import com.example.hackathon_2024.domain.contract.dto.request.ContractRequest;
import com.example.hackathon_2024.domain.contract.dto.response.CheckContractResponse;
import com.example.hackathon_2024.domain.contract.dto.response.ContractDetailResponse;
import com.example.hackathon_2024.domain.contract.dto.response.ContractWritePageResponse;
import com.example.hackathon_2024.domain.contract.service.CheckContractService;
import com.example.hackathon_2024.domain.contract.service.ConclusionContractService;
import com.example.hackathon_2024.domain.contract.service.ContractDetailsService;
import com.example.hackathon_2024.domain.contract.service.CreateContractService;
import com.example.hackathon_2024.domain.contract.service.ShowContractWritePageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/contract")
public class ContractController {

    private final ShowContractWritePageService showContractWritePageService;

    private final CreateContractService createContractService;

    private final CheckContractService checkContractService;

    private final ContractDetailsService contractDetailsService;

    private final ConclusionContractService conclusionContractService;

    @GetMapping("/{investId}")
    public ContractWritePageResponse showContractWritePage(@PathVariable Long investId) {
        return showContractWritePageService.showContractWritePage(investId);
    }

    @PostMapping()
    public void createContract(@RequestBody ContractRequest request) {
        createContractService.createContract(request);
    }

    @GetMapping("/check")
    public CheckContractResponse checkContract() {
        return checkContractService.checkContract();
    }

    @GetMapping("/detail/{investId}")
    public ContractDetailResponse contractDetail(@PathVariable Long investId) {
        return contractDetailsService.contractDetail(investId);
    }

    @PostMapping("/conclusion")
    public void conclusionContract(@RequestBody ConclusionRequest request) {
        conclusionContractService.conclusionContract(request);
    }
}

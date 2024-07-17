package com.example.hackathon_2024.domain.invest.controller;

import com.example.hackathon_2024.domain.invest.dto.request.InvestRequest;
import com.example.hackathon_2024.domain.invest.service.RequestInvestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/invest")
public class InvestController {

    private final RequestInvestService requestInvestService;

    @PostMapping("/request")
    public void requestInvest(@RequestBody InvestRequest request) {
        requestInvestService.requestInvest(request);
    }
}

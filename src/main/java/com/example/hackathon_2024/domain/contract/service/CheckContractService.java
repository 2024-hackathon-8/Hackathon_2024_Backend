package com.example.hackathon_2024.domain.contract.service;

import com.example.hackathon_2024.domain.contract.dto.response.CheckContractResponse;
import com.example.hackathon_2024.domain.user.entity.User;
import com.example.hackathon_2024.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CheckContractService {

    private final UserFacade userFacade;

    public CheckContractResponse checkContract() {

        User user = userFacade.currentUser();

        return CheckContractResponse.builder()
                .representative_name(user.getName())
                .phone_number(user.getPhoneNumber())
                .build();
    }
}

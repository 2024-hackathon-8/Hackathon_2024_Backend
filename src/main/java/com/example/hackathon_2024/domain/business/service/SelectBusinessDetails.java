package com.example.hackathon_2024.domain.business.service;

import com.example.hackathon_2024.domain.business.dto.response.DetailBusinessResponse;
import com.example.hackathon_2024.domain.business.entity.Business;
import com.example.hackathon_2024.domain.business.entity.BusinessTag;
import com.example.hackathon_2024.domain.business.exception.BusinessNotFoundException;
import com.example.hackathon_2024.domain.business.repository.BusinessRepository;
import com.example.hackathon_2024.domain.business.repository.BusinessTagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SelectBusinessDetails {

    private final BusinessRepository businessRepository;

    private final BusinessTagRepository businessTagRepository;

    public DetailBusinessResponse selectBusinessDetails(Long businessId) {
        Business business = businessRepository.findById(businessId)
                .orElseThrow(()-> BusinessNotFoundException.EXCEPTION);

        return DetailBusinessResponse.builder()
                .businessName(business.getBusinessName())
                .oneLiner(business.getOneLiner())
                .vision(business.getVision())
                .writePurpose(business.getWritePurpose())
                .totalInvestment(business.getTotalInvestment())
                .tags(businessTagRepository.findAllByBusinessId(businessId).stream().map(BusinessTag::getTag).toList())
                .build();
    }
}
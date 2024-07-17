package com.example.hackathon_2024.domain.business.service;

import com.example.hackathon_2024.domain.business.dto.request.BusinessRequest;
import com.example.hackathon_2024.domain.business.entity.Business;
import com.example.hackathon_2024.domain.business.entity.BusinessTag;
import com.example.hackathon_2024.domain.business.entity.BusinessTagId;
import com.example.hackathon_2024.domain.business.repository.BusinessRepository;
import com.example.hackathon_2024.domain.business.repository.BusinessTagRepository;
import com.example.hackathon_2024.domain.tag.repository.TagRepository;
import com.example.hackathon_2024.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateBusinessService {

    private final BusinessRepository businessRepository;

    private final TagRepository tagRepository;

    private final BusinessTagRepository businessTagRepository;

    private final UserFacade userFacade;

    public void createBusiness(BusinessRequest request) {
       Business business = businessRepository.save(
               Business.builder()
                    .businessName(request.getBusinessName())
                    .oneLiner(request.getOneLiner())
                    .businessIntroduce(request.getBusinessIntroduce())
                    .vision(request.getVision())
                    .totalInvestment(request.getTotalInvestment())
                    .user(userFacade.currentUser())
                    .build());

        if(!request.getTag_name().isEmpty()) {
            request.getTag_name().stream()
                    .map(tagRepository::findByTagName)
                    .forEach(tag -> businessTagRepository.save(new BusinessTag(new BusinessTagId(), business, tag)));
        }
    }
}
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
                    .businessName(request.getBusiness_name())
                    .oneLiner(request.getOne_liner())
                    .businessIntroduce(request.getBusiness_introduce())
                    .vision(request.getVision())
                    .totalInvestment(request.getTotal_investment())
                    .user(userFacade.currentUser())
                    .build());

        if(!request.getTags().isEmpty()) {
            request.getTags().stream()
                    .map(tagRepository::findByTagName)
                    .forEach(tag -> businessTagRepository.save(new BusinessTag(new BusinessTagId(), business, tag)));
        }
    }
}
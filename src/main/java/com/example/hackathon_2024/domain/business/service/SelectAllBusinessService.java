package com.example.hackathon_2024.domain.business.service;

import com.example.hackathon_2024.domain.business.dto.response.AllBusinessResponse;
import com.example.hackathon_2024.domain.business.entity.Business;
import com.example.hackathon_2024.domain.business.entity.BusinessTag;
import com.example.hackathon_2024.domain.business.repository.BusinessRepository;
import com.example.hackathon_2024.domain.business.repository.BusinessTagRepository;
import com.example.hackathon_2024.domain.tag.entity.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SelectAllBusinessService {

    private final BusinessRepository businessRepository;

    private final BusinessTagRepository businessTagRepository;

    public List<AllBusinessResponse> selectAllBusiness() {
        return businessRepository.findAll()
                .stream()
                .map(this::createAllBusinessResponse)
                .toList();
    }

    private AllBusinessResponse createAllBusinessResponse(Business business) {
        List<Tag> tags = getTagsForBusiness(business.getId());
        return AllBusinessResponse.builder()
                .business_id(business.getId())
                .business_name(business.getBusinessName())
                .one_liner(business.getOneLiner())
                .total_investment(business.getTotalInvestment())
                .tags(tags)
                .build();
    }

    private List<Tag> getTagsForBusiness(Long businessId) {
        List<BusinessTag> businessTags = businessTagRepository.findAllByBusinessId(businessId);
        return businessTags.stream()
                .map(BusinessTag::getTag)
                .toList();
    }
}

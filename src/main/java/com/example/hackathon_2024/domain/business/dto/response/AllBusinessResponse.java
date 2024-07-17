package com.example.hackathon_2024.domain.business.dto.response;

import com.example.hackathon_2024.domain.tag.entity.Tag;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class AllBusinessResponse {
    private String businessName;
    private String oneLiner;
    private Long totalInvestment;
    private List<Tag> tags;
}
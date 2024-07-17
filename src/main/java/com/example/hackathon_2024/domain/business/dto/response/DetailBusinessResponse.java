package com.example.hackathon_2024.domain.business.dto.response;

import com.example.hackathon_2024.domain.tag.entity.Tag;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class DetailBusinessResponse {

    private String business_name;

    private String one_liner;

    private String vision;

    private String write_purpose;

    private Long total_investment;

    List<Tag> tags;
}

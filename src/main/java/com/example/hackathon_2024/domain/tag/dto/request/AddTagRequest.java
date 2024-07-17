package com.example.hackathon_2024.domain.tag.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class AddTagRequest {

    @NotBlank
    private String tag_name;
}

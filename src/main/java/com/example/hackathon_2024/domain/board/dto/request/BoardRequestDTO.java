package com.example.hackathon_2024.domain.board.dto.request;

import lombok.Builder;
import lombok.Data;

@Data
public class BoardRequestDTO {
    private String title;
    private String vision;
    private String content;
    private String purpose;
}

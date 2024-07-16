package com.example.hackathon_2024.domain.board.dto.response;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class BoardFindByIdResponseDTO {
    private String title;
    private String intro;
    private String content;
    private Long totalAmount;
}

package com.example.hackathon_2024.domain.board.dto.response;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ShowAllBoardsResponseDTO {
    private String title;
    private String intro;
    private Long totalAmount;
}

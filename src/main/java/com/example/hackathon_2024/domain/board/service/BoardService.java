package com.example.hackathon_2024.domain.board.service;

import com.example.hackathon_2024.domain.board.dto.request.BoardRequestDTO;
import com.example.hackathon_2024.domain.board.dto.response.BoardFindByIdResponseDTO;
import com.example.hackathon_2024.domain.board.dto.response.ShowAllBoardsResponseDTO;
import com.example.hackathon_2024.domain.board.entity.Board;
import com.example.hackathon_2024.domain.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public List<ShowAllBoardsResponseDTO> showAllBoards() {
        List<Board> boardList = boardRepository.findAll();

        return boardList.stream().map(board -> ShowAllBoardsResponseDTO.builder()
                .title(board.getTitle())
                .intro(board.getIntro())
                .totalAmount(board.getTotalAmount())
                .build()).toList();
    }

    public void createBoard(BoardRequestDTO boardRequestDTO) {
        Board board = Board.builder()
                .title(boardRequestDTO.getTitle())
                .vision(boardRequestDTO.getVision())
                .content(boardRequestDTO.getContent())
                .purpose(boardRequestDTO.getPurpose())
                .build();

        boardRepository.save(board);
    }

    public BoardFindByIdResponseDTO boardFindById(Long id) {
        Board board =  boardRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("not found."));

        return BoardFindByIdResponseDTO.builder()
                .title(board.getTitle())
                .intro(board.getIntro())
                .content(board.getContent())
                .totalAmount(board.getTotalAmount())
                .build();
    }

}

package com.example.hackathon_2024.domain.board.controller;

import com.example.hackathon_2024.domain.board.dto.request.BoardRequestDTO;
import com.example.hackathon_2024.domain.board.dto.response.BoardFindByIdResponseDTO;
import com.example.hackathon_2024.domain.board.dto.response.ShowAllBoardsResponseDTO;
import com.example.hackathon_2024.domain.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @GetMapping()
    public List<ShowAllBoardsResponseDTO> showAllBoards() {
        return boardService.showAllBoards();
    }

    @GetMapping("{id}")
    public BoardFindByIdResponseDTO boardFindById(@PathVariable("id") Long id) {
        return boardService.boardFindById(id);
    }

    @PostMapping
    public void createBoard(BoardRequestDTO boardRequestDTO) {
        boardService.createBoard(boardRequestDTO);
    }
}

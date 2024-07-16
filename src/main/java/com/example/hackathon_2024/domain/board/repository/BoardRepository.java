package com.example.hackathon_2024.domain.board.repository;

import com.example.hackathon_2024.domain.board.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
}

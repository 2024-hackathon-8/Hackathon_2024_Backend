package com.example.hackathon_2024.domain.board.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@EqualsAndHashCode
@NoArgsConstructor
public class BoardTagId implements Serializable {
    @Column(name = "board_id")
    private Long boardId;

    @Column(name = "tag_id")
    private Long tagId;
}
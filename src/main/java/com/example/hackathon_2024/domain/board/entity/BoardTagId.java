package com.example.hackathon_2024.domain.board.entity;

import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Embeddable
@EqualsAndHashCode
@NoArgsConstructor
public class BoardTagId implements Serializable {
    private UUID boardId;

    private Long tagId;
}

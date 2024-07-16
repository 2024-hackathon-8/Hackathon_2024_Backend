package com.example.hackathon_2024.domain.board.entity;

import com.example.hackathon_2024.domain.tag.entity.Tag;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BoardTag {

    @EmbeddedId
    private BoardTagId id;

    @MapsId("boardId")
    @ManyToOne
    @JoinColumn(name = "board_id")
    private Board boardId;

    @MapsId("tagId")
    @ManyToOne
    @JoinColumn(name = "tag_id")
    private Tag tagId;
}

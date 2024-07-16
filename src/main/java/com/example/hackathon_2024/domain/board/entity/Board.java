package com.example.hackathon_2024.domain.board.entity;

import com.example.hackathon_2024.domain.user.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "vision", nullable = false)
    private String vision;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "purpose", nullable = false)
    private String purpose;

    @Column(name = "intro")
    private String intro;

    @Column(name = "total_amount")
    private Long totalAmount;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private User user;
}

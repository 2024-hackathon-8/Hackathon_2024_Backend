package com.example.hackathon_2024.domain.business.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@EqualsAndHashCode
@NoArgsConstructor
public class BusinessTagId implements Serializable {
    @Column(name = "business_id")
    private Long businessId;

    @Column(name = "tag_id")
    private Long tagId;
}
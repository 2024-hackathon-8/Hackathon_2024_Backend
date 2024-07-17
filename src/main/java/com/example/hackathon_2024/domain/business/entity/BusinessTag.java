package com.example.hackathon_2024.domain.business.entity;

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
public class BusinessTag {

    @EmbeddedId
    private BusinessTagId id;

    @MapsId("businessId")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "business_id", nullable = false)
    private Business business;

    @MapsId("tagId")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tag_id", nullable = false)
    private Tag tag;
}

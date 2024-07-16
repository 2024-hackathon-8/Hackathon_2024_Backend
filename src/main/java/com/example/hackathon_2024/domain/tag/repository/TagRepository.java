package com.example.hackathon_2024.domain.tag.repository;

import com.example.hackathon_2024.domain.tag.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Long> {
    Tag findByTagName(String tagName);

    Boolean existsByTagName(String tagName);
}

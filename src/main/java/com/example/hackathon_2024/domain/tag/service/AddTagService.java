package com.example.hackathon_2024.domain.tag.service;

import com.example.hackathon_2024.domain.tag.dto.request.AddTagRequest;
import com.example.hackathon_2024.domain.tag.entity.Tag;
import com.example.hackathon_2024.domain.tag.exception.DuplicatedTagException;
import com.example.hackathon_2024.domain.tag.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddTagService {

    private final TagRepository tagRepository;

    public void addTag(AddTagRequest request) {
        if(tagRepository.existsByTagName(request.getTagName())) throw DuplicatedTagException.EXCEPTION;

        tagRepository.save(new Tag(request.getTagName()));
    }
}

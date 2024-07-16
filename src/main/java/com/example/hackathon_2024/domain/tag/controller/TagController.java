package com.example.hackathon_2024.domain.tag.controller;

import com.example.hackathon_2024.domain.tag.dto.request.AddTagRequest;
import com.example.hackathon_2024.domain.tag.service.AddTagService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tag")
public class TagController {

    private final AddTagService addTagService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/add")
    public void addTag(@RequestBody @Valid AddTagRequest request) {
        addTagService.addTag(request);
    }
}

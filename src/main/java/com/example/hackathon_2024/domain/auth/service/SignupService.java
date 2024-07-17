package com.example.hackathon_2024.domain.auth.service;

import com.example.hackathon_2024.domain.auth.dto.request.SignupRequest;
import com.example.hackathon_2024.domain.tag.repository.TagRepository;
import com.example.hackathon_2024.domain.user.entity.User;
import com.example.hackathon_2024.domain.user.entity.UserTag;
import com.example.hackathon_2024.domain.user.entity.UserTagId;
import com.example.hackathon_2024.domain.user.repository.UserRepository;
import com.example.hackathon_2024.domain.user.repository.UserTagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SignupService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final TagRepository tagRepository;

    private final UserTagRepository userTagRepository;

    public void signup(SignupRequest request) {
        User user = userRepository.save(
                User.builder()
                        .accountId(request.getAccount_id())
                        .password(passwordEncoder.encode(request.getPassword()))
                        .name(request.getName())
                        .password(passwordEncoder.encode(request.getPassword()))
                        .phoneNumber(request.getPhone_number())
                        .userType(request.getUser_type())
                        .build());

        if(!request.getTags().isEmpty()) {
            request.getTags().stream()
                    .map(tagRepository::findByTagName)
                    .forEach(tag -> userTagRepository.save(new UserTag(new UserTagId(), user, tag)));
        }
    }
}
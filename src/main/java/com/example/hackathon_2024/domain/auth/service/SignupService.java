package com.example.hackathon_2024.domain.auth.service;

import com.example.hackathon_2024.domain.auth.dto.request.SignupRequest;
import com.example.hackathon_2024.domain.user.entity.User;
import com.example.hackathon_2024.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SignupService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public void signup(SignupRequest request) {
        User user = userRepository.save(
                User.builder()
                        .accountId(request.getAccountId())
                        .nickname(request.getNickname())
                        .password(passwordEncoder.encode(request.getPassword()))
                        .heartCount(0)
                        .build());
    }
}

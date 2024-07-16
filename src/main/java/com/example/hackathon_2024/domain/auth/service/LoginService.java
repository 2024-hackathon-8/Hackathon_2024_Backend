package com.example.hackathon_2024.domain.auth.service;

import com.example.hackathon_2024.domain.auth.dto.request.LoginRequest;
import com.example.hackathon_2024.domain.auth.dto.response.TokenResponse;
import com.example.hackathon_2024.domain.auth.exception.PasswordMismatchException;
import com.example.hackathon_2024.domain.user.entity.User;
import com.example.hackathon_2024.domain.user.exception.UserNotFoundException;
import com.example.hackathon_2024.domain.user.repository.UserRepository;
import com.example.hackathon_2024.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final JwtTokenProvider jwtTokenProvider;

    public TokenResponse login(LoginRequest request) {
        User user = userRepository.findByAccountId(request.getAccount_id())
                .orElseThrow(()-> UserNotFoundException.EXCEPTION);

        if(!passwordEncoder.matches(request.getPassword(), user.getPassword())) throw PasswordMismatchException.EXCEPTION;

        return jwtTokenProvider.receiveToken(request.getAccount_id());
    }
}

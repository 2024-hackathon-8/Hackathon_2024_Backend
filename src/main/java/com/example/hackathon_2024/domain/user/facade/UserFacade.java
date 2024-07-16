package com.example.hackathon_2024.domain.user.facade;

import com.example.hackathon_2024.domain.user.entity.User;
import com.example.hackathon_2024.domain.user.exception.NotAuthenticatedException;
import com.example.hackathon_2024.domain.user.exception.UserNotFoundException;
import com.example.hackathon_2024.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserFacade {

    private final UserRepository userRepository;

    public User currentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || !authentication.isAuthenticated()) {
            throw new NotAuthenticatedException("인증되지 않는 유저입니다.");
        }

        return userRepository.findByAccountId(authentication.getName())
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);
    }
}
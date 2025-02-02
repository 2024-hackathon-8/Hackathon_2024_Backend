package com.example.hackathon_2024.domain.auth.controller;

import com.example.hackathon_2024.domain.auth.dto.request.LoginRequest;
import com.example.hackathon_2024.domain.auth.dto.request.PhoneNumberRequest;
import com.example.hackathon_2024.domain.auth.dto.request.SignupRequest;
import com.example.hackathon_2024.domain.auth.dto.request.VerifyRequest;
import com.example.hackathon_2024.domain.auth.dto.response.TokenResponse;
import com.example.hackathon_2024.domain.auth.service.LoginService;
import com.example.hackathon_2024.domain.auth.service.SendMessageService;
import com.example.hackathon_2024.domain.auth.service.SignupService;
import com.example.hackathon_2024.domain.auth.service.VerifySmsService;
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
@RequestMapping("/auth")
public class AuthController {

    private final SignupService signupService;

    private final LoginService loginService;

    private final SendMessageService sendMessageService;

    private final VerifySmsService verifySmsService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/signup")
    public void signup(@RequestBody @Valid SignupRequest request) {
        signupService.signup(request);
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/login")
    public TokenResponse login(@RequestBody @Valid LoginRequest request) {
        return loginService.login(request);
    }

    @PostMapping("/message")
    public void sendMessage(@RequestBody PhoneNumberRequest request) {
        sendMessageService.sendSMS(request);
    }

    @PostMapping("/verifySms")
    public Boolean verifySms(@RequestBody VerifyRequest request) {
        return verifySmsService.verifySms(request);
    }
}

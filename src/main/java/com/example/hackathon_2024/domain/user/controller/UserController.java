package com.example.hackathon_2024.domain.user.controller;

import com.example.hackathon_2024.domain.user.dto.response.MyInfoResponse;
import com.example.hackathon_2024.domain.user.service.MyInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final MyInfoService myInfoService;

    @PostMapping("/my-info")
    public MyInfoResponse myInfo() {
        return myInfoService.myInfo();
    }
}
 
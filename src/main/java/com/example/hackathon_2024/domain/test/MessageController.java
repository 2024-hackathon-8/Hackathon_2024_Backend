package com.example.hackathon_2024.domain.test;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/message")
public class MessageController {

    private final MessageService messageService;

    @PostMapping("/{phoneNumber}")
    public void message(@PathVariable String phoneNumber) {
        messageService.sendSMS(phoneNumber);
    }

    @PostMapping("/verifySms")
    public String verifySms(@RequestBody UserDto request) {
        return messageService.verifySms(request);
    }
}

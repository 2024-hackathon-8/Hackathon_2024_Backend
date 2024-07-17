package com.example.hackathon_2024.domain.alarm.controller;

import com.example.hackathon_2024.domain.alarm.dto.request.AlarmRequest;
import com.example.hackathon_2024.domain.alarm.service.CreateAlarmService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/alarm")
public class AlarmController {

    private final CreateAlarmService createAlarmService;

    @PostMapping()
    public void createAlarm(@RequestBody AlarmRequest request) {
        createAlarmService.crateAlarm(request);
    }
}

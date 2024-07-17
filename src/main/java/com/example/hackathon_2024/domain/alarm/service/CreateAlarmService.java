package com.example.hackathon_2024.domain.alarm.service;

import com.example.hackathon_2024.domain.alarm.dto.AlarmRequest;
import com.example.hackathon_2024.domain.alarm.entity.Alarm;
import com.example.hackathon_2024.domain.alarm.repository.AlarmRepository;
import com.example.hackathon_2024.domain.user.exception.UserNotFoundException;
import com.example.hackathon_2024.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateAlarmService {

    private final AlarmRepository alarmRepository;

    private final UserRepository userRepository;

    public void crateAlarm(AlarmRequest request) {

        alarmRepository.save(
                Alarm.builder()
                        .alarmType(request.getAlarm_type())
                        .senderName(request.getSender_name())
                        .recipientId(userRepository.findByAccountId(request.getRecipient_account_id()).orElseThrow(()-> UserNotFoundException.EXCEPTION))
                        .money(request.getMoney())
                        .sendTime(request.getSend_time())
                        .build());
    }
}
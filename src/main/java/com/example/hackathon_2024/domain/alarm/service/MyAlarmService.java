package com.example.hackathon_2024.domain.alarm.service;

import com.example.hackathon_2024.domain.alarm.dto.response.AlarmResponse;
import com.example.hackathon_2024.domain.alarm.repository.AlarmRepository;
import com.example.hackathon_2024.domain.user.entity.User;
import com.example.hackathon_2024.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MyAlarmService {

    private final UserFacade userFacade;

    private final AlarmRepository alarmRepository;

    public List<AlarmResponse> myAlarm() {
        User user = userFacade.currentUser();

        return alarmRepository.findAllByRecipientId(user)
                .stream()
                .map(AlarmResponse::new)
                .toList();
    }
}

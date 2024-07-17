package com.example.hackathon_2024.domain.alarm.dto.response;

import com.example.hackathon_2024.domain.alarm.entity.Alarm;
import com.example.hackathon_2024.domain.alarm.entity.enums.AlarmType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class AlarmResponse {

    private AlarmType alarm_type;

    private String sender_name;

    private Long money;

    public AlarmResponse(Alarm alarm) {
        this.alarm_type = alarm.getAlarmType();
        this.sender_name = alarm.getSenderName();
        this.money = alarm.getMoney();
    }
}
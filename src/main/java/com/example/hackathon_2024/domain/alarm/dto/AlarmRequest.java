package com.example.hackathon_2024.domain.alarm.dto;

import com.example.hackathon_2024.domain.alarm.entity.enums.AlarmType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
public class AlarmRequest {

    @NotNull
    private AlarmType alarm_type;

    @NotBlank
    private String sender_name;

    @NotBlank
    private String recipient_account_id;

    private Long money;

    @NotNull
    private LocalDate send_time;
}

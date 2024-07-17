package com.example.hackathon_2024.domain.alarm.entity;

import com.example.hackathon_2024.domain.alarm.entity.enums.AlarmType;
import com.example.hackathon_2024.domain.user.entity.User;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Alarm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "alarm_type", nullable = false)
    private AlarmType alarmType;

    @OneToOne
    @JoinColumn(name = "sender_account_id")
    private User senderAccountId;

    @ManyToOne
    @JoinColumn(name = "recipient_account_id")
    private User recipientAccountId;

    @Column(name = "money")
    private Long money;

    @Column(name = "send_time", nullable = false)
    private LocalDate sendTime;
}

package com.example.hackathon_2024.domain.auth.service;

import com.example.hackathon_2024.domain.auth.dto.request.VerifyRequest;
import com.example.hackathon_2024.domain.auth.repository.SmsCertification;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VerifySmsService {

    private final SmsCertification smsCertification;

    public String verifySms(VerifyRequest requestDto) {
        if (isVerify(requestDto)) {
            throw new IllegalArgumentException("인증번호가 일치하지 않습니다.");
        }
        smsCertification.deleteSmsCertification(requestDto.getPhone_number());

        return "인증 완료되었습니다.";
    }

    private boolean isVerify(VerifyRequest requestDto) {
        return !(smsCertification.hasKey(requestDto.getPhone_number()) &&
                smsCertification.getSmsCertification(requestDto.getPhone_number())
                        .equals(requestDto.getRandom_number()));
    }
}

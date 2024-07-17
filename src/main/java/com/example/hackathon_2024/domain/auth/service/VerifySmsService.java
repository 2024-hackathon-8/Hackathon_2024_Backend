package com.example.hackathon_2024.domain.auth.service;

import com.example.hackathon_2024.domain.auth.dto.request.VerifyRequest;
import com.example.hackathon_2024.domain.auth.repository.SmsCertification;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VerifySmsService {

    private final SmsCertification smsCertification;

    public Boolean verifySms(VerifyRequest requestDto) {
        if (isVerify(requestDto)) {
            return false;
        }
        smsCertification.deleteSmsCertification(requestDto.getPhone_number());

        return true;
    }

    private boolean isVerify(VerifyRequest requestDto) {
        return !(smsCertification.hasKey(requestDto.getPhone_number()) &&
                smsCertification.getSmsCertification(requestDto.getPhone_number())
                        .equals(requestDto.getRandom_number()));
    }
}

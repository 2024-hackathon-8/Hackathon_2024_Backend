package com.example.hackathon_2024.domain.user.service;

import com.example.hackathon_2024.domain.business.repository.BusinessRepository;
import com.example.hackathon_2024.domain.invest.dto.response.InvestmentResponse;
import com.example.hackathon_2024.domain.invest.dto.response.ReceiveInvestResponse;
import com.example.hackathon_2024.domain.invest.repository.InvestRepository;
import com.example.hackathon_2024.domain.tag.entity.Tag;
import com.example.hackathon_2024.domain.user.dto.response.MyInfoResponse;
import com.example.hackathon_2024.domain.user.entity.User;
import com.example.hackathon_2024.domain.user.entity.UserTag;
import com.example.hackathon_2024.domain.user.facade.UserFacade;
import com.example.hackathon_2024.domain.user.repository.UserTagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MyInfoService {

    private final UserFacade userFacade;

    private final UserTagRepository userTagRepository;

    private final InvestRepository investRepository;

    private final BusinessRepository businessRepository;

    public List<Tag> getMyTags(User user) {
        return userTagRepository.findAllByUserId(user)
                .stream()
                .map(UserTag::getTagId)
                .toList();
    }

    public List<ReceiveInvestResponse> getReceiveInvests(User user) {
        return businessRepository.findAllByUser(user)
                .stream()
                .flatMap(business -> investRepository.findAllByBusiness(business).stream())
                .map(ReceiveInvestResponse::new)
                .collect(Collectors.toList());
    }

    public List<InvestmentResponse> getInvestments(User user) {
        return investRepository.findAllByUser(user)
                .stream()
                .map(InvestmentResponse::new)
                .toList();
    }

    public MyInfoResponse myInfo() {
        User user = userFacade.currentUser();

        return MyInfoResponse.builder()
                .account_id(user.getAccountId())
                .name(user.getName())
                .user_type(user.getUserType())
                .phone_number(user.getPhoneNumber())
                .tags(getMyTags(user))
                .my_amount(user.getMyAmount())
                .receive_invest(getReceiveInvests(user))
                .my_investment(getInvestments(user))
                .build();
    }
}
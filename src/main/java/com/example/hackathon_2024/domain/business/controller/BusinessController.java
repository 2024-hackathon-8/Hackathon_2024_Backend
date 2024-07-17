package com.example.hackathon_2024.domain.business.controller;

import com.example.hackathon_2024.domain.business.dto.request.BusinessRequest;
import com.example.hackathon_2024.domain.business.dto.response.AllBusinessResponse;
import com.example.hackathon_2024.domain.business.dto.response.DetailBusinessResponse;
import com.example.hackathon_2024.domain.business.service.CreateBusinessService;
import com.example.hackathon_2024.domain.business.service.SelectAllBusinessService;
import com.example.hackathon_2024.domain.business.service.SelectBusinessDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/business")
@RequiredArgsConstructor
public class BusinessController {

    private final CreateBusinessService createBusinessService;

    private final SelectAllBusinessService selectAllBusinessService;

    private final SelectBusinessDetails selectBusinessDetails;

    @PostMapping()
    public void createBusiness(BusinessRequest request) {
        createBusinessService.createBusiness(request);
    }

    @GetMapping("/all")
    public List<AllBusinessResponse> showAllBusiness() {
        return selectAllBusinessService.selectAllBusiness();
    }

    @GetMapping("/details/{businessId}")
    public DetailBusinessResponse selectBusinessDetail(@PathVariable Long businessId) {
        return selectBusinessDetails.selectBusinessDetails(businessId);
    }
}

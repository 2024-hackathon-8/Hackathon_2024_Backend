package com.example.hackathon_2024.domain.business.repository;

import com.example.hackathon_2024.domain.business.entity.Business;
import com.example.hackathon_2024.domain.business.entity.BusinessTag;
import com.example.hackathon_2024.domain.business.entity.BusinessTagId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BusinessTagRepository extends JpaRepository<BusinessTag, BusinessTagId> {
    List<BusinessTag> findAllByBusinessId(Long businessId);
}

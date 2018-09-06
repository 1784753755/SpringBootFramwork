package com.service;

import com.model.Appraise;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AppraiseService {
    Integer countAppraise(Integer productId);

    Appraise getAppraiseById(Integer appraiseId);

    void updateAppraise(Appraise appraise);

    void delAppraise(Integer appraiseId);

    void saveAppraise(Appraise appraise);
}

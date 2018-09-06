package com.service.impl;

import com.dao.AppraiseDao;
import com.model.Appraise;
import com.service.AppraiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AppraiseServiceImpl implements AppraiseService {
    @Autowired
    private AppraiseDao appraiseDao;


    @Override
    public Integer countAppraise(Integer productId) {
        return appraiseDao.count(productId);
    }

    @Override
    public Appraise getAppraiseById(Integer appraiseId) {
        return appraiseDao.Appraise(appraiseId);
    }

    @Override
    public void updateAppraise(Appraise appraise) {
        appraiseDao.updateAppraise(appraise);
    }

    @Override
    public void delAppraise(Integer appraiseId) {
        appraiseDao.delAppraise(appraiseId);
    }

    @Override
    public void saveAppraise(Appraise appraise) {
        appraiseDao.saveAppraise(appraise);
    }
}

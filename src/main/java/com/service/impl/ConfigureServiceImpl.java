package com.service.impl;

import com.dao.ConfigDao;
import com.model.Config;
import com.service.ConfigureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConfigureServiceImpl implements ConfigureService {
    @Autowired
    private ConfigDao configDao;

    @Override
    public void addConfigure(Config config) {
        this.configDao.addConfig(config);
        this.configDao.updateUid();
    }
}

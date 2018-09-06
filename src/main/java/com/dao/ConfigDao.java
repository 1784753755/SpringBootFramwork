package com.dao;

import com.model.Config;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
        /*后台管理模块*/
public interface ConfigDao {
    List<Config> getConfig();

    void addConfig(Config config);

    //同步更新uid
    void updateUid();
}

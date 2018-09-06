package com.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassDao {
    //获取Table id(对应的学院)
      Class getTableId(@Param("className") String className, @Param("year") int year, @Param("ud") String ud);
}

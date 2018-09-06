package com.dao;

import com.common.AbstractPageForm;
import com.model.Appraise;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppraiseDao {
    List<Appraise> getAllAppraiseAll(AbstractPageForm abstractPageForm,@Param("productId")Integer productId);


    Integer count(@Param("CountProductId") Integer productId);

    Appraise Appraise(Integer appraiseId);

    void updateAppraise(Appraise appraise);
    void delAppraise (Integer delAppraiseId);

    void saveAppraise(Appraise appraise);
}

package com.dao;

import com.common.AbstractPageForm;
import com.model.Goods;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
@Repository
public interface GoodsDao {
    /*获取所有产品*/
    List<Goods> getGoods(AbstractPageForm abstractPageForm);

    /*增加一个商品*/
    void setGoods(Goods goods);

    int getCountNum();

    Goods getGoodsById(@Param("ID") int id);

    void updateGood(Goods goods);

    void delGoods(Integer productId);

    List<Goods> getGoodsByType (AbstractPageForm abstractPageForm, @Param("categoryName") Integer getCategory);

    int getCountNumByCategory(int categoryId);

    List<Goods> getGoodsByName(String getName);
       /*前台展示*/
    List<Goods> getProductDisplay();
}

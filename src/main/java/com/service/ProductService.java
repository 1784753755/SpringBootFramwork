package com.service;

import com.model.Goods;
import com.model.domain.DomainProduct;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    int countNum();
    Goods getGoodsById(int id);
    void  addGoods(Goods goods);
    void  upDates(Goods goods);

    void delProduct(Integer productId);

    int countNumByCategory(int categoryId);

    List<Goods> getGoodsByName(String getName);

    /*----------------前台service*/
    List<DomainProduct> getGoodsDisplay();

    DomainProduct getGoodsDisplayById(Integer integer);
}

package com.service;

import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

@Service
public interface SelectPageService {
    public PageInfo selectGoods(int pageSize,int pageNum);
    public PageInfo selectDemos(int pageSize,int pageNum);
    public PageInfo selectProductCategory(int pageSize,int pageNum);
    public PageInfo selectGoodsByCategory(int pageSize,int pageNum,Integer categoryId);
    public  PageInfo selectAppraise(int pageSize, int pageNum, Integer productId);
    public PageInfo selectOrder(int pageSize,int pageNum);
    public  PageInfo selectAuthorGroup(int pageSize,int pageNum);
}

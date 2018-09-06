package com.service.impl;

import com.common.AbstractPageForm;

import com.dao.*;
import com.github.pagehelper.PageInfo;
import com.model.*;
import com.service.SelectPageService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.List;


@Configuration
public class SelectPage extends AbstractPageForm implements SelectPageService {
    /**/
    @Autowired
    SqlSessionFactory sqlSessionFactory;
    @Autowired
    private TestDao testDao;
    @Autowired
    private GoodsDao goodsDao;
    @Autowired
    private ProductCategoryDao productCategoryDao;
    @Autowired
    private AppraiseDao appraiseDao;
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private AuthorGroupDao authorGroupDao;
    private static final long serialVersionUID = 1L;

    public SelectPage selectAll(int pageSize, int pageNum) {
        pageSize = pageSize == 0 ? 10 : pageSize;
        SelectPage TestPage = new SelectPage();
        TestPage.setPageSize(pageSize);
        TestPage.setPageNum(pageNum);
      /*  //自动更改展示的页码
        List<Demo> selectAll = testDao.getAllTest(TestPage.enablePaging());
        PageInfo<Demo> pageInfo = new PageInfo<>(selectAll);*/
        return TestPage;
    }

    @Override
    public PageInfo selectGoods(int pageSize, int pageNum) {
        //自动更改展示的页码
        List<Goods> selectAll = goodsDao.getGoods(selectAll(pageSize, pageNum).enablePaging());
        PageInfo<Goods> pageInfo = new PageInfo<>(selectAll);
        return pageInfo;
    }

    @Override
    public PageInfo selectDemos(int pageSize, int pageNum) {
        //自动更改展示的页码
        List<Demo> selectAll = testDao.getAllTest(selectAll(pageSize, pageNum).enablePaging());
        PageInfo<Demo> pageInfo = new PageInfo<>(selectAll);
        return pageInfo;
    }

    @Override
    public PageInfo selectProductCategory(int pageSize, int pageNum) {
        //自动更改展示的页码
        List<ProductCategory> selectAll = productCategoryDao.getAllCategories(selectAll(pageSize, pageNum).enablePaging());
        PageInfo<ProductCategory> pageInfo = new PageInfo<>(selectAll);
        return pageInfo;
    }

    @Override
    public PageInfo selectGoodsByCategory(int pageSize, int pageNum, Integer getCategory) {
        //自动更改展示的页码
        List<Goods> selectAll = goodsDao.getGoodsByType(selectAll(pageSize, pageNum).enablePaging(), getCategory);
        PageInfo<Goods> pageInfo = new PageInfo<>(selectAll);
        return pageInfo;
    }

    @Override
    public PageInfo selectAppraise(int pageSize, int pageNum, Integer productId) {
        List<Appraise> selectAll = appraiseDao.getAllAppraiseAll(selectAll(pageSize, pageNum).enablePaging(), productId);
        PageInfo<Appraise> pageInfo = new PageInfo<>(selectAll);
        return pageInfo;
    }

    @Override
    public PageInfo selectOrder(int pageSize, int pageNum) {

        List<Order> selectAll = orderDao.getOrderBySelect(selectAll(pageSize, pageNum).enablePaging());
        PageInfo<Order> pageInfo = new PageInfo<>(selectAll);
        return pageInfo;
    }

    @Override
    public PageInfo selectAuthorGroup(int pageSize, int pageNum) {
        List<AuthorGroup> selectAll = authorGroupDao.getAuthorGroupBySelect(selectAll(pageSize, pageNum).enablePaging());
        PageInfo<AuthorGroup> pageInfo = new PageInfo<>(selectAll);
        return pageInfo;
    }
}

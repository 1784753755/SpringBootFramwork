package com.common;

import com.github.pagehelper.PageHelper;

import java.io.Serializable;
/*
 * @autor cai sheng tang
 * 设置mybatis  分页属性
 * */
public abstract class AbstractPageForm<T extends AbstractPageForm<T>> implements Serializable{
    private static final long serialVersionUID = 1L;
    /**
     * @Description 页码为首页
     */
    protected int pageNum = 1;

    /**
     * @Description 每页显示数量，默认为10
     */
    protected int pageSize = 10;

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {

        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
    /**
     * @Title enablePaging
     * @Description 启用分页
     * @return
     */

    public final T enablePaging() {
//        设置
        PageHelper.startPage(pageNum, pageSize);
        return (T) this;
    }
}

package com.dao;

import com.common.AbstractPageForm;
import com.model.ProductCategory;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
@Repository
public interface ProductCategoryDao {
    /*数总数*/
    int  Count();
    /*非分页查找*/
    List<ProductCategory>   getAllCategoryAll();
    /*分页查找*/
    List<ProductCategory>   getAllCategories(AbstractPageForm abstractPageForm);
    //获取所有的产品类别
    ProductCategory  SelectCategoryById(@Param("CgryId")Integer id);

    void Update(ProductCategory productCategory);

    void Delete(@Param("ID") int ID);
     //新增一个分类
    void addproductCagegory(ProductCategory productCategory);
    //添加所有的产品类别
    //删除 某个产品类别
    //更新某个产品类别
}

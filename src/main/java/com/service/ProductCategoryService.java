package com.service;

import com.model.ProductCategory;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.PropertyPermission;

@Service
public interface ProductCategoryService {
    /* 添加*/
      void AddProductCategory(ProductCategory productCategory);
    /* 查询*/
     List<ProductCategory> getProductCategories();
     ProductCategory getProductCategoryById(Integer id);
    /* 编辑*/
     void EditProductCategory(ProductCategory productCategory);
    /*删除*/
    void  Delete( int  getId);
    /*获取总数*/
    Integer  Count();




    /*  void update(ProductCategory productCategory);*/
}

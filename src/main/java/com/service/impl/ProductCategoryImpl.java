package com.service.impl;

import com.dao.ProductCategoryDao;
import com.model.ProductCategory;
import com.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductCategoryImpl implements ProductCategoryService {
    @Autowired
    private ProductCategoryDao productCategoryDao;
    @Override
    public void AddProductCategory(ProductCategory productCategory) {
          productCategoryDao.addproductCagegory(productCategory);
    }

    @Override
    public List<ProductCategory> getProductCategories() {
        return  productCategoryDao.getAllCategoryAll();
    }
    @Override
    public ProductCategory getProductCategoryById(Integer id) {
      ProductCategory productCategory=  productCategoryDao.SelectCategoryById(id);
        return productCategory;
    }
    @Override
    public void EditProductCategory(ProductCategory productCategory) {
          productCategoryDao.Update(productCategory);
    }
    @Override
    public void Delete(int propertyPermission) {
        productCategoryDao.Delete(propertyPermission);
    }

    @Override
    public Integer Count() {
     Integer count=   productCategoryDao.Count();
        return count;
    }
}

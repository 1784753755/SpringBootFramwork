package com.service;

import com.model.Color;
import com.model.Package;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface PackageService {
     /*查询*/
    List<Package> getAllPackage();
    /*增加*/
    void insertPackage(Package aPackage);
    /*查询*/
    Package selectPackageById(Integer id);
    /*删除*/
    void  deletePackage(Integer id);
    /*修改*/
    void updatePackage(Package color);

    List<Package> getPackageByProductId(Integer productId);
    Package getPackageByID(Integer id);

    Package getPackageByProductIdAndTitle(Integer goodsId, String getTitle);


}

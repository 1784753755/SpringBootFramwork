package com.service.impl;

import com.dao.PackageDao;
import com.model.Color;
import com.model.Package;
import com.service.PackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
 @Service
public class PackageServiceImpl implements PackageService {
    @Autowired
    private PackageDao packageDao;
    @Override
    public List<Package> getAllPackage() {
        return packageDao.getAllPackage() ;
    }

    @Override
    public Package selectPackageById(Integer id) {
        return null;
    }

    @Override
    public void deletePackage(Integer id) {
             packageDao.delPackage(id);
    }

    @Override
    public void updatePackage(Package packages) {
             packageDao.updatePackage(packages);
    }

    @Override
    public List<Package> getPackageByProductId(Integer productId) {
        return packageDao.getPackageByProductId(productId);
    }

    @Override
    public Package getPackageByID(Integer id) {
        return packageDao.getPackageById(id);
    }

    @Override
    public Package getPackageByProductIdAndTitle(Integer goodsId, String getTitle) {
        return packageDao.getPackageByProductIdAndTitle(goodsId,getTitle);
    }

     @Override
     public void insertPackage(Package aPackage) {
         packageDao.insertPackage(aPackage);
     }
 }

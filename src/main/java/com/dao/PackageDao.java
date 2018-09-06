package com.dao;

import com.model.Package;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PackageDao {

    List<Package> getAllPackage();

    List<Package> getPackageByProductId(Integer ProductId);

    void insertPackage(Package aPackage);

    Package getPackageByProductIdAndTitle(@Param("GID") Integer goodsId,@Param("Title") String getTitle);

    Package getPackageById(Integer id);

    void updatePackage(Package packages);

    void delPackage(Integer id);
}

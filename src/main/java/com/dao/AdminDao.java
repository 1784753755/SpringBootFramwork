package com.dao;

import com.model.Admin;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminDao {
      List<Admin> getAdmins();

      void addAdmin(Admin a);

      Admin getAdminById(Integer getAdminId);

    Integer getMaxId();

    Admin getAdminByGetName(@Param("getName") String getName,@Param("getPwd") String getPwd);
}

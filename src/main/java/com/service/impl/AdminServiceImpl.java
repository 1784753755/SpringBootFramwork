package com.service.impl;

import com.dao.AdminDao;
import com.model.Admin;
import com.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminDao adminDao;
    @Override
    public Admin getAdminById(Integer getAdminId) {
        return adminDao.getAdminById(getAdminId);
    }

    @Override
    public boolean savaAdmin(Admin admin) {
        try{
              adminDao.addAdmin(admin);
              return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public Integer getMaxId() {
        return adminDao.getMaxId();
    }
}

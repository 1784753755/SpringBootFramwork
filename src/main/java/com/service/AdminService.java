package com.service;

import com.model.Admin;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AdminService {
    /*通过Id获取对应的admin*/
    Admin getAdminById(Integer getAdminId);
    /*获取所有的admin*/
    boolean savaAdmin(Admin admin);

    Integer getMaxId();
}

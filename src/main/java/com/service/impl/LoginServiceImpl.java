package com.service.impl;

import com.dao.AdminDao;
import com.model.Admin;
import com.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private AdminDao adminDao;
    @Autowired
    private HttpServletRequest request;

    @Override
    public boolean verificate(String getName, String getPwd) {
        Admin admin = adminDao.getAdminByGetName(getName, getPwd);
        if (admin == null)
            return false;
        /*设置admin权限*/
        HttpSession session = request.getSession();
        if (admin.getPower() == 1) {
            /*超级管理员*/
            session.setAttribute("power", true);
        } else {
            /*普通管理员*/
                session.setAttribute("power", false);
        }
        session.setAttribute("adminName", admin.getName());
        return true;
    }
}

package com.service.impl;

import com.dao.AuthorGroupDao;
import com.model.Admin;
import com.model.AuthorGroup;
import com.service.AdminService;
import com.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Time;
import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {
    @Autowired
    private AuthorGroupDao authorGroupDao;
    @Autowired
    private AdminService adminService;

    @Override
    public AuthorGroup getAuthorByHostUrl(String domainHostUrl) {
        return authorGroupDao.getAuthor(domainHostUrl);
    }

    @Override
    public Integer getCount() {
        return authorGroupDao.getCount();
    }

    @Override
    public AuthorGroup getAuthorById(Integer integer) {
        return authorGroupDao.getAuthorById(integer);
    }

    @Override
    public void updateService(AuthorGroup authorGroup) {
        authorGroupDao.updateAuthorGroup(authorGroup);
    }

    @Override
    public void deleteGroup(Integer integer) {
        authorGroupDao.delAuthorGroup(integer);
    }

    @Override
    public boolean saveAuthorGroup(AuthorGroup authorGroup, String getCurrentIp) throws UnknownHostException {

        Integer getId = adminService.getMaxId();
        Admin admin = new Admin();
        admin.setAdminId((getId + 1));
        admin.setName("admin_" + (getId+1));
        admin.setPwd("adnmin168168");
        admin.setAddTime(com.common.Time.getCurrentTime());
        admin.setIp(getCurrentIp);
        admin.setLastIp(getCurrentIp);
        admin.setStatus(1);
        if (adminService.savaAdmin(admin)) {
            authorGroup.setUid(++getId);
            authorGroupDao.saveAuthorGroup(authorGroup);
            return true;
        } else return false;
    }

    @Override
    public boolean selectDomain(String getDoaminName) {
      List<AuthorGroup> authorGroup =authorGroupDao.selectDomainName(getDoaminName);
       if(authorGroup==null)
           return false;
       return  true;
    }

    @Override
    public List<AuthorGroup> getAuthorByName(String trim) {
        return authorGroupDao.selectByName(trim);
    }

    @Override
    public List<AuthorGroup> getAuthorByGroup(String trim) {
        return authorGroupDao.selectByGroup(trim);
    }

    @Override
    public List<AuthorGroup> getAuthorByType(String trim) {
        return authorGroupDao.selectByType(trim);
    }

    @Override
    public List<AuthorGroup> getAuthorByMoveMent(String trim) {
        return authorGroupDao.selectByMovement(trim);
    }
}

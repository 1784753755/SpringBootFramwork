package com.service;

import com.model.AuthorGroup;
import org.springframework.stereotype.Service;

import java.net.UnknownHostException;
import java.util.List;

@Service
public interface AuthorService {
    /*栈点拥有者*/
    AuthorGroup getAuthorByHostUrl(String domainHostUrl);

    Integer getCount();

    AuthorGroup getAuthorById(Integer integer);

    void updateService(AuthorGroup authorGroup);

    void deleteGroup(Integer integer);

    boolean saveAuthorGroup(AuthorGroup authorGroup,String getCurrentIp) throws UnknownHostException;

    boolean selectDomain(String getDoaminName);

    List<AuthorGroup> getAuthorByName(String trim);

    List<AuthorGroup> getAuthorByGroup(String trim);

    List<AuthorGroup> getAuthorByType(String trim);

    List<AuthorGroup> getAuthorByMoveMent(String trim);
}

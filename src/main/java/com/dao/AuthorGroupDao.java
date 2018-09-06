package com.dao;

import com.common.AbstractPageForm;
import com.model.AuthorGroup;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @AuthorGroupDao  站点拥有者*/
@Repository
public interface AuthorGroupDao {

    AuthorGroup getAuthor(String domainHostUrl);

    List<AuthorGroup> getAuthorGroupBySelect(AbstractPageForm abstractPageForm);

    Integer getCount();

    AuthorGroup getAuthorById(Integer AuthorId);

    void updateAuthorGroup(AuthorGroup authorGroup);

    void delAuthorGroup(Integer delAuthorId);

    void saveAuthorGroup(AuthorGroup authorGroup);

    List<AuthorGroup> selectDomainName(String domainName);

    List<AuthorGroup> selectByName(@Param("name") String trim);

    List<AuthorGroup> selectByGroup(@Param("group")String trim);

    List<AuthorGroup> selectByType(@Param("type")String trim);

    List<AuthorGroup> selectByMovement(@Param("movement")String trim);
}

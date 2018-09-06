package com.dao;

import com.common.AbstractPageForm;
import com.model.Demo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestDao {

      void addTest(Demo t);

      List<Demo> getAllTest(AbstractPageForm abstractPageForm);
}

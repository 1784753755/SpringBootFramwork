package com.service;

import com.model.Admin;
import org.springframework.stereotype.Service;

@Service
public interface LoginService {
/*登入匹配*/
    boolean verificate(String getName, String getPwd);
    /*连接数据库*/

}

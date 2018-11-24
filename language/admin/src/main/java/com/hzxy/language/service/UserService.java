package com.hzxy.language.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hzxy.language.common.base.BaseService;
import com.hzxy.language.entity.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserService extends BaseService<User>{



    List<User> selectByName(String username);



    User login(String username, String password);


}

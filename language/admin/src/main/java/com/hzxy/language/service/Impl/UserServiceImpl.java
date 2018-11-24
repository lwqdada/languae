package com.hzxy.language.service.Impl;

import com.hzxy.language.dao.UserDao;
import com.hzxy.language.entity.User;
import com.hzxy.language.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;


    //新增用户
    @Transactional
    @Override
    public int add(User user) {
        user.setCreated(new Date());
        user.setUpdated(new Date());
        return userDao.insert(user);
    }

    /**
     * 用户列表
     */
    @Override
    public List<User> selectAll() {
        //pageHeler帮我们生成分页语句
        List<User> users=userDao.selectAll();
        return users;

    }


    /**
     * 分页
     * @param start
     * @param length
     * @param
     */
    @Override
    public List<User> page(int start, int length, User user) {
        int count=count(user);
        Map<String,Object> params=new HashMap<>();
        params.put("start",start);
        params.put("length",length);
        params.put("pageParams",user);
        return userDao.page(params);
    }

    /**
     * 根据符合查询条件得出的比数
     * @return
     */
    @Override
    public int count(User user) {
        return userDao.count(user);
    }


    @Override
    public User selectById(Long id) {
        return userDao.selectById(id);
    }

    @Override
    public List<User> selectByName(String username) {
        return userDao.selectByName(username);
    }

    @Override
    @Transactional(readOnly = false)
    public int  update(User user) {
         user.setUpdated(new Date());
        return userDao.update(user);
    }

    @Override
    public int deleteById(Long id) {
        return userDao.deleteById(id);
    }

    @Override
    public User login(String username, String password) {
        return userDao.login(username,password);
    }
}

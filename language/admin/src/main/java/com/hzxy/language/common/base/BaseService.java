package com.hzxy.language.common.base;

import com.hzxy.language.entity.User;

import java.util.List;

public interface BaseService<T> {
    //新增
    int add(T entity);

    //查询所有
    List<T> selectAll();

    //分页
    List<T> page(int start,int length,T entity);

    //查询总笔数
    int count(T entity);

    //根据id查询记录
   T selectById(Long id);

    //更新
    int update(T entity);

    //根据id查询记录
    int deleteById(Long id);
}

package com.hzxy.language.common.base;

import com.hzxy.language.entity.User;

import java.util.List;
import java.util.Map;

/**
 * 所有数据访问层的基类
 */
public interface BaseDao<T> {

    //新增
    int insert(T entity);

    //展示所有信息
    List<T> selectAll();

    //更新对应的类信息信息
    int update(T entity);

    //根据ID删除记录
    int deleteById(Long id);

    //根据Id查询记录
   T selectById(Long id);

    /**
     * 分页查询
     * @param params,需要两个参数，start记录开始的 位置，length每页的记录数
     * @return
     */
    List<T> page(Map<String, Object> params);

    /**
     * 查询笔数
     * @return
     */
    int count(T entity);




}

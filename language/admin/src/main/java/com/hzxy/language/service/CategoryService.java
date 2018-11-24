package com.hzxy.language.service;

import com.hzxy.language.entity.Category;

import java.util.List;

public interface CategoryService {
    //查询所有
    List<Category> selectAll();

    /*根据父级节点ID查询所有子节点*/
    List<Category> selectByPid(Long pid);

    /*根据id删除记录*/
    int deleteById(long id);

    /*根据当前的id更新信息*/
    int update(Category category);

    //根据分类id查询分类信息
    Category selectById(long id);

    //新增下级目录
    int insert(Category category);
}

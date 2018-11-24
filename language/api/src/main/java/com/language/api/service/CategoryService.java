package com.language.api.service;

import com.hzxy.domain.pojo.entity.Category;

import java.util.List;

public interface CategoryService {
    /*查看所有分类*/
    List<Category> selectAll();
}

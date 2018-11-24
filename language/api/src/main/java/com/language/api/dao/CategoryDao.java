package com.language.api.dao;

import com.hzxy.domain.pojo.entity.Category;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryDao {
    /*查看所有分类*/
    List<Category> selectAll();
}

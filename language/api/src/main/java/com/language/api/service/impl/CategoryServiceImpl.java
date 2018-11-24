package com.language.api.service.impl;

import com.hzxy.domain.pojo.entity.Category;
import com.language.api.dao.CategoryDao;
import com.language.api.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryDao categoryDao;
    @Override
    public List<Category> selectAll() {
        return categoryDao.selectAll();
    }
}

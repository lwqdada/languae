package com.language.api.service.impl;

import com.hzxy.domain.pojo.entity.AreaContent;
import com.hzxy.domain.pojo.entity.Category;
import com.language.api.dao.ConentDao;
import com.language.api.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContentServiceImpl implements ContentService {
    @Autowired
    private ConentDao conentDao;
    @Override
    public List<AreaContent> selectAll() {
        return conentDao.selectAll();
    }
}

package com.language.api.service;

import com.hzxy.domain.pojo.entity.AreaContent;

import java.util.List;

public interface ContentService {
    //查询所有内容信息
    List<AreaContent> selectAll();
}

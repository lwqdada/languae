package com.language.api.service;


import com.hzxy.domain.pojo.entity.XiangYin;

import java.util.List;

public interface XiangyinService {
    //新增
    int insert(XiangYin xiangyin);

    //展示所有信息
    List<XiangYin> selectAll();


    //根据Id查询记录
    XiangYin selectById(Long id);
}

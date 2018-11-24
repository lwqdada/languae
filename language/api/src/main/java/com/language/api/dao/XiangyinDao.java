package com.language.api.dao;

import com.hzxy.domain.pojo.entity.XiangYin;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface XiangyinDao  {

    //新增
    int insert(XiangYin xiangyin);

    //展示所有信息
    List<XiangYin> selectAll();


    //根据Id查询记录
    XiangYin selectById(Long id);

}

package com.language.api.service.impl;

import com.hzxy.domain.pojo.entity.XiangYin;
import com.language.api.dao.XiangyinDao;
import com.language.api.service.XiangyinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class XiangyinServiceImpl implements XiangyinService{

    @Autowired
    private XiangyinDao  xiangyinDao;
    @Override
    public int insert(XiangYin xiangyin) {
        if(xiangyin.getId()==null){
            xiangyin.setCreated(new Date());
            xiangyin.setUpdated(new Date());
        }
        return xiangyinDao.insert(xiangyin);
    }

    @Override
    public List<XiangYin> selectAll() {
        return xiangyinDao.selectAll();
    }

    @Override
    public XiangYin selectById(Long id) {
        return  xiangyinDao.selectById(id);
    }
}

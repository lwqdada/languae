package com.hzxy.language.service.Impl;

import com.hzxy.language.dao.XiangYinDao;
import com.hzxy.language.entity.XiangYin;
import com.hzxy.language.service.XiangYinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class XiangYinServiceImpl implements XiangYinService{
    @Autowired
    private XiangYinDao xiangYinDao;


    @Override
    public int add(XiangYin entity) {
           if(entity.getId()==null){
             entity.setCreated(new Date());
             entity.setUpdated(new Date());
           }
        return xiangYinDao.insert(entity);
    }

    @Override
    public List<XiangYin> selectAll() {
        return xiangYinDao.selectAll();
    }

    @Override
    public List<XiangYin> page(int start, int length, XiangYin entity)
    {
        int count=count(entity);
        Map<String,Object> params=new HashMap<>();
        params.put("start",start);
        params.put("length",length);
        params.put("pageParams",entity);
        return xiangYinDao.page(params);
    }

    @Override
    public int count(XiangYin entity) {
        return xiangYinDao.count(entity);
    }

    @Override
    public XiangYin selectById(Long id) {
        return xiangYinDao.selectById(id);
    }

    @Override
    public int update(XiangYin entity) {
        if(entity.getId()!=null){
            entity.setUpdated(new Date());
        }
        return xiangYinDao.update(entity);
    }

    @Override
    public int deleteById(Long id) {
        return xiangYinDao.deleteById(id);
    }
}

package com.hzxy.language.service.Impl;

import com.hzxy.language.dao.AreaContentDao;
import com.hzxy.language.entity.AreaContent;
import com.hzxy.language.entity.User;
import com.hzxy.language.service.AreaContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AreaContentServiceImpl implements AreaContentService{

    @Autowired
    private AreaContentDao areaContentDao;


    //查询所有内容
    @Override
    public List<AreaContent> selectAll() {
        return areaContentDao.selectAll();
    }

    /**
     * 分页
     * @param start
     * @param length
     * @param
     */
    @Override
    public List<AreaContent> page(int start, int length, AreaContent areaContent) {
        int count=count(areaContent);
        Map<String,Object> params=new HashMap<>();
        params.put("start",start);
        params.put("length",length);
        params.put("pageParams",areaContent);
        return areaContentDao.page(params);
    }

    /**
     * 根据符合查询条件得出的比数
     * @return
     */
    @Override
    public int count(AreaContent areaContent) {
        return areaContentDao.count(areaContent);
    }


    //根据id删除记录
    @Override
    public int deleteById(Long id) {
        return areaContentDao.deleteById(id);
    }



    //新增内容
    @Transactional(readOnly = false)
    @Override
    public int add(AreaContent areaContent) {
        areaContent.setCreated(new Date());
        areaContent.setUpdated(new Date());
        return areaContentDao.insert(areaContent);

    }

     //根据id查找对应的记录信息
    @Override
    public AreaContent selectById(Long id) {
        return areaContentDao.selectById(id);
    }

    @Override
    public int update(AreaContent areaContent) {
        return areaContentDao.update(areaContent);
    }
}

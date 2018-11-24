package com.language.api.dao;

import com.hzxy.domain.pojo.entity.AreaContent;
import com.hzxy.domain.pojo.entity.Category;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Repository
public interface ConentDao {

    //查询所有内容信息
     List<AreaContent> selectAll();

}

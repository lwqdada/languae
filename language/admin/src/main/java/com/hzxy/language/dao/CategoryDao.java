package com.hzxy.language.dao;

import com.hzxy.language.common.base.BaseDao;
import com.hzxy.language.entity.Category;
import com.hzxy.language.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryDao extends BaseDao<Category>{


 /*根据父级节点ID查询所有子节点*/
 List<Category> selectByPid(Long pid);

 /*根据父级节点ID查询所有子节点*/
 Category selectByPidSingle(Long pid);

}

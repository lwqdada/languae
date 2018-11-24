package com.hzxy.language.service.Impl;

import com.hzxy.language.dao.CategoryDao;
import com.hzxy.language.entity.Category;
import com.hzxy.language.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryDao categoryDao;

    @Override
    public List<Category> selectAll() {
        return categoryDao.selectAll();
    }

    @Override
    public List<Category> selectByPid(Long pid) {
        return categoryDao.selectByPid(pid);
    }

    @Override
    public int deleteById(long id) {
        return categoryDao.deleteById(id);
    }

    @Transactional(readOnly = false)
    @Override
    public int update(Category category) {
          category.setUpdated(new Date());
        return categoryDao.update(category);
    }


    @Override
    public Category selectById(long id) {
        return categoryDao.selectById(id);
    }

    /*新增下级目录*/
    @Transactional(readOnly = false)
    public int insert(Category category) {

      if(category.getParentId()!=null){
          Category parent = categoryDao.selectByPidSingle(category.getParentId());

          //判断该父节点是否为isparent，是的话则可以在它后面追加节点，否则不可以
          if(parent.getIsParent()){
              category.setCreated(new Date());
              category.setUpdated(new Date());
            return  categoryDao.insert(category);
          }else{
              return 0;
          }

      }

        return 1;
    }


}

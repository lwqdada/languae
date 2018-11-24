package com.hzxy.language.web.controller;

import com.hzxy.language.entity.AreaContent;
import com.hzxy.language.entity.Category;
import com.hzxy.language.entity.User;
import com.hzxy.language.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @ModelAttribute
    public Category  getCategory(Long id){
        Category category=new Category();
        if(id!=null){
        category= categoryService.selectById(id);

        }
        else{
           category=new Category();
        }
        return category;

    }

    /*跳转到用户列表*/
    @GetMapping("/selectALLCategory")
    public String selectAll(Model model){
        List<Category> targetList=new ArrayList<>();
        List<Category> sourceList = categoryService.selectAll();

        //排序
        sortList(sourceList,targetList,0L);
        model.addAttribute("categories",targetList);
        return "category_list";
    }

    /*树形结构*/
    @ResponseBody
    @PostMapping ("/tree/data")
    public List<Category> treeData(Long id){
       if(id==null){
           id=0L;
       }
        return categoryService.selectByPid(id);
    }

    /**
     * 排序
     * @param sourceList
     * @param targeList
     * @param
     */
    private void sortList(List<Category> sourceList,List<Category> targeList,Long parentID){

      for(Category category:sourceList){
          if(category.getParentId().equals( parentID)){
             targeList.add(category);

             //判断有没有子节点，如果有的话继续追加
             if (category.getIsParent()){
                for(Category category1:sourceList){
                    if(category1.getParentId().equals(category.getId())){
                        sortList(sourceList,targeList,category.getId());
                        break;
                    }
                }
             }
          }

      }
    }




    /*根据id删除记录*/
    @GetMapping("deleteByCategoryId")
    public String deleteById(long id){
        int i = categoryService.deleteById(id);
        if(i!=0){
            System.out.printf("删除用户成功！");
        }
        return "redirect:/category/selectALLCategory";
    }



    //跳转到更新表单
    @GetMapping ("/updateCategory_form")
    public String updateCategory_form(){
        return "updateCategory_form";
    }

    //更新分类信息
    @PostMapping("/updateCategory")
    public String updatebyUser(Category category){
        int update = categoryService.update(category);
        return "redirect:/category/selectALLCategory";
    }

    //跳转到新增下级目录界面
     @GetMapping("/nextCategory")
    public String nextCategory(){
        return "next_category_form";
    }

    @PostMapping("/AddnextCategory")
    public String addCategory(Category category) {
        int insert = categoryService.insert(category);
        return "redirect:/category/selectALLCategory";
    }





}

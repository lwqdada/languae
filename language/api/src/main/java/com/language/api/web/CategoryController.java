package com.language.api.web;

import com.hzxy.domain.pojo.entity.Category;
import com.hzxy.domain.utils.ResultModel;
import com.hzxy.domain.utils.ResultTools;
import com.language.api.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/selectAll")
    private ResultModel selectAll(){
        Map<String,Object> result=new HashMap<>();
        List<Category> categories = categoryService.selectAll();
        result.put("data",categories);
        return ResultTools.result(0,"",result);
    }

}

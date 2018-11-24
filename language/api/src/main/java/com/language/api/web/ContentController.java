package com.language.api.web;

import com.hzxy.domain.pojo.entity.AreaContent;
import com.hzxy.domain.pojo.entity.Category;
import com.hzxy.domain.utils.ResultModel;
import com.hzxy.domain.utils.ResultTools;
import com.language.api.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping ("/content")
public class ContentController {
    @Autowired
    private ContentService contentService;

    @GetMapping("/lists")
    private ResultModel lists(){
        Map<String,Object> result=new HashMap<>();
        List<AreaContent> areaContents = contentService.selectAll();
        result.put("data",areaContents);
        return ResultTools.result(0,"",result);
    }
}

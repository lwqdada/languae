package com.language.api.web;

import com.hzxy.domain.pojo.entity.AreaContent;
import com.hzxy.domain.pojo.entity.XiangYin;
import com.hzxy.domain.utils.ResultModel;
import com.hzxy.domain.utils.ResultTools;
import com.language.api.service.XiangyinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/xiangyin")
public class XiangYinController {

    @Autowired
    private XiangyinService xiangyinService;


    /*新增记录*/
    @GetMapping("/add")
    public ResultModel add( XiangYin xiangYin){
        Map<String,Object> result=new HashMap<>();
        int insert = xiangyinService.insert(xiangYin);
        int code;
        if(insert!=0){
           code=0;
        }else{
           code=1;
        }
        result.put("data",insert);
        return ResultTools.result(code,"",result);
    }


    /*查询所有*/
    @GetMapping("/selectAll")
    private  ResultModel selectAll(){
        Map<String,Object> result=new HashMap<>();
        List<XiangYin> xiangYins = xiangyinService.selectAll();
        int code;
        if(xiangYins!=null){
            code=0;
        }else{
            code=1;

        }
        result.put("data",xiangYins);
        return ResultTools.result(0,"",result);
    }

    /*根据id获取记录信息*/
    @GetMapping("/selectById")
    private  ResultModel selectById(Long id){
        Map<String,Object> result=new HashMap<>();
        XiangYin xiangYin = xiangyinService.selectById(id);
        int code;
        if(xiangYin!=null){
            code=0;
        }else{
            code=1;

        }
        result.put("data",xiangYin);
        return ResultTools.result(code,"",result);
    }


}

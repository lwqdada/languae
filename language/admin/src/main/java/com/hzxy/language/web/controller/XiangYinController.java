package com.hzxy.language.web.controller;

import com.hzxy.language.entity.User;
import com.hzxy.language.entity.XiangYin;
import com.hzxy.language.service.XiangYinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/xiangyin")
public class XiangYinController {

    @Autowired
    private XiangYinService xiangYinService;


    @ModelAttribute
    public XiangYin getXiangYin(Long id){
        XiangYin xiangYin=null;
        if(id!=null){
            xiangYin = xiangYinService.selectById(id);//根据id获取用户信息
        }
        else{
            xiangYin=new XiangYin();
        }
        return  xiangYin;

    }

    /*跳转到乡音列表*/
    @RequestMapping("/xiangyinList")
    public String xiangyinList(){
        return "xiangyin_list";
    }


    /*查询所有记录*/
    @GetMapping("/selectAll")
    public List<XiangYin> selectAll(){
        return xiangYinService.selectAll();
    }

    /*新增记录*/
   @PostMapping("/add")
    public int  add(XiangYin xiangYin){
       return xiangYinService.add(xiangYin);
    }


    @ResponseBody
    //根据id查找记录
    @GetMapping("/selectById")
    public XiangYin selectById(Long id){
        return xiangYinService.selectById(id);
    }


    //根据id删除记录
    @GetMapping("/deleteById")
    public int deleteByid(Long id){
        return xiangYinService.deleteById(id);
    }

    //根据id更新
    @PostMapping("/update")
    public String update(XiangYin xiangYin){
        xiangYinService.update(xiangYin);
        return "redirect:/xiangyin/xiangyinList";
    }

    /*跳转到乡音更新表单*/
    @GetMapping("/updateXiangyinform")
    public String updateXiangyinForm(){
        return "updateXiangyin_form";
    }


    /**
            * 分页查询
     * @param request
     * @param xiangYin
     * @return
             */
    @ResponseBody
    @RequestMapping(value ="/page",method = RequestMethod.GET)
    public Map<String,Object> page(HttpServletRequest request, XiangYin xiangYin) {
        Map<String, Object> result = new HashMap<>();
        String strdraw = request.getParameter("draw");
        String strstart = request.getParameter("start");
        String strlength = request.getParameter("length");

        int draw = strdraw == null ? 0 : Integer.parseInt(strdraw);
        int start = strstart == null ? 0 : Integer.parseInt(strstart);
        int length = strlength == null ? 0 : Integer.parseInt(strlength);
        //封装dataTables需要的结果
        List<XiangYin> xiangYins = xiangYinService.page(start, length,xiangYin);
        int count = xiangYinService.count(xiangYin);
        result.put("draw", draw);
        result.put("recordsTotal", count);
        result.put("recordsFiltered", count);
        result.put("data", xiangYins);
        return result;

    }







}

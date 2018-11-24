package com.hzxy.language.web.controller;

import com.hzxy.language.entity.AreaContent;
import com.hzxy.language.entity.Category;
import com.hzxy.language.service.AreaContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/content")
public class AreaContentController {
    @Autowired
    private AreaContentService areaContentService;

    @ModelAttribute
    public AreaContent getAreaContentbyId(Long id){
        AreaContent areaContent=new AreaContent();
        if(id!=null){
            areaContent= areaContentService.selectById(id);

        }
        else{
            areaContent=new AreaContent();
        }
        return areaContent;

    }


    /**
     * 分页查询
     * @param request
     * @param
     * @return
     */

    @ResponseBody
    @RequestMapping(value ="/area/page",method = RequestMethod.GET)
    public Map<String,Object> page(HttpServletRequest request, AreaContent areaContent) {
        Map<String, Object> result = new HashMap<>();
        String strdraw = request.getParameter("draw");
        String strstart = request.getParameter("start");
        String strlength = request.getParameter("length");

        int draw = strdraw == null ? 0 : Integer.parseInt(strdraw);
        int start = strstart == null ? 0 : Integer.parseInt(strstart);
        int length = strlength == null ? 0 : Integer.parseInt(strlength);
        //封装dataTables需要的结果
        List<AreaContent> areaContents=areaContentService.page(start, length,areaContent);
        int count = areaContentService.count(areaContent);
        result.put("draw", draw);
        result.put("recordsTotal", count);
        result.put("recordsFiltered", count);
        result.put("data", areaContents);

        return result;

    }

    //跳转到内容分类页面
    @GetMapping("/areaContents")
    private  String contenLists(){
        return "areaContents_list";
    }


    //跳转到新增内容表单
    @GetMapping ("/content_form")
    private  String contForm(){
        return "content_form";
    }

    //跳转到更新表单
     @GetMapping("/updateContentForm")
    private  String updateForm(){
        return "update_content_form";
    }

    //根据Id删除用户
    @GetMapping("/deleteByareaId")
    public String deleteById(long id){
        areaContentService.deleteById(id);
        return "redirect:/content/areaContents";

    }

    //新增内容
    @PostMapping("/addContent")
    public String addContent(AreaContent areaContent,Model model){
        int add = areaContentService.add(areaContent);
        if(add!=0){
          model.addAttribute("msg","新增内容成功！");
        }else
        {
            model.addAttribute("msg","新增内容失败！");
            return "redirect:/content/content_form";

        }

        return "redirect:/content/areaContents";
    }

    //更改内容信息
    @PostMapping("/updateAreaContent")
    public String updatebycontentId(AreaContent areaContent){
        int update =areaContentService.update(areaContent);
        return "redirect:/content/areaContents";
    }


    //根据id获取内容信息
    @ResponseBody
    @GetMapping("/getContentById")
    private AreaContent  getContentById(long id){
        return areaContentService.selectById(id);
    }




}

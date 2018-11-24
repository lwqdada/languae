package com.hzxy.language.web.controller;

import com.github.pagehelper.PageInfo;
import com.hzxy.language.entity.User;
import com.hzxy.language.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
   @Autowired
   private  UserService userService;

   /* //获取所有用户的记录
    @GetMapping("/list")
    public Map<String,Object> list(){
        Map<String,Object> resulst=new HashMap<>();
        List<User> users = userService.selectUsers();
        resulst.put("data",users);
        return resulst;
    }*/



    /**
     * 分页查询
     * @param request
     * @param user
     * @return
     */
    @ResponseBody
    @RequestMapping(value ="/page",method = RequestMethod.GET)
    public Map<String,Object> page(HttpServletRequest request, User user) {
        Map<String, Object> result = new HashMap<>();
        String strdraw = request.getParameter("draw");
        String strstart = request.getParameter("start");
        String strlength = request.getParameter("length");

        int draw = strdraw == null ? 0 : Integer.parseInt(strdraw);
        int start = strstart == null ? 0 : Integer.parseInt(strstart);
        int length = strlength == null ? 0 : Integer.parseInt(strlength);
        //封装dataTables需要的结果
        List<User> newsUsers = userService.page(start, length,user);
        int count = userService.count(user);
        result.put("draw", draw);
        result.put("recordsTotal", count);
        result.put("recordsFiltered", count);
        result.put("data", newsUsers);

        return result;

    }

    //根据Id获取用户信息
    @GetMapping("/getUserById")
    public User getUserById(Long id){
        return userService.selectById(id);
    }




}

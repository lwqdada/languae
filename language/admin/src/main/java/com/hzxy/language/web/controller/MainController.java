package com.hzxy.language.web.controller;

import com.hzxy.language.entity.User;
import com.hzxy.language.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class MainController {
    @Autowired
    private UserService userService;

    @ModelAttribute
    public User  getUser(Long id){
       User user=null;
        if(id!=null){
         user = userService.selectById(id);//根据id获取用户信息
        }
        else{
           user=new User();
        }
        return  user;

    }
    //跳转到控制面板
    @GetMapping("/main")
    public String  main(){
        return "main";
    }

    //跳转到新增用户表单
    @GetMapping("/user_form")
    public String  user_form(){
        return "user_form";
    }


    //跳转到用户列表
    @GetMapping("/user_list")
    public String  user_list(){
        return "user_list";
    }

    //跳转到更新表单
    @GetMapping("/update_form")
    public String  update_form(){
        return "update_form";
    }

    //根据Id删除用户
    @GetMapping("/deleteById")
    @ResponseBody
    public Map<String,Object> deleteById(long id){
        Map<String,Object> result=new HashMap<>();
        int d=userService.deleteById(id);
        System.out.println(d);
        result.put("data",d);

       return result;

    }

    //新增用户

    @PostMapping("/adduser")
    public String addUser(User user, Model model){
        if(user.getUsername()!=null&&user.getPassword()!=null&&user.getEmail()!=null&&user.getPhone()!=null){
            userService.add(user);
            model.addAttribute("msg","新增用户成功！");
        }else{
            model.addAttribute("必填的信息不能为空，请重新填！");
            return "redirect:/user/user_form";
        }


         return "redirect:/user/user_list";

    }


    //更新用户
    @PostMapping("/update")
    public String updatebyUser(User user){
          userService.update(user);
        return "redirect:/user/user_list";

    }

}

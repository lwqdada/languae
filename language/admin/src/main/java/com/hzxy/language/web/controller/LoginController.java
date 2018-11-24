package com.hzxy.language.web.controller;

import com.hzxy.language.entity.User;
import com.hzxy.language.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {
    @Autowired
    private UserService userService;
    //登录跳转页面
   /* @RequestMapping(value = {"","login"})*/
   @RequestMapping("/user/login")
    public String login(){

        return "login";
    }

    @RequestMapping(value="/user/login",method= RequestMethod.POST)
    public String login(@RequestParam(required = true)String username, @RequestParam(required = true) String password, HttpServletRequest httpServletRequest, Model model){
        User user= userService.login(username, password);

        //登录失败
        if (user==null){
            if("".equals(username)||"".equals(password)){
                model.addAttribute("message","用户名或密码不能为空，请重新输入!");
            }
            else{
                model.addAttribute("message","用户名或密码错误，请重新输入!");
            }
            return  login();


        }
        //登录成功
        else {
            //将登录信息放到会话中
            httpServletRequest.getSession().setAttribute("user",user);
            return  "redirect:/user/main";
        }
    }
    @RequestMapping("/user/logout")
    public String logout(HttpServletRequest request){
    request.getSession().invalidate();
        return "redirect:/user/login";
    }




}

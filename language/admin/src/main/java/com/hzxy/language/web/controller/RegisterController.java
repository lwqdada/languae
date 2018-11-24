package com.hzxy.language.web.controller;

import com.hzxy.language.entity.User;
import com.hzxy.language.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/user")
public class RegisterController {
    @Autowired
    private UserService userService;

    @GetMapping("/registerForm")
    public String greetingForm(Model model) {
        model.addAttribute("user", new User());
        return "Register";
    }

    @PostMapping("/register")
    public String register( User user, Model model) {

        if(user.getUsername()!=null&&user.getPassword()!=null&&user.getEmail()!=null&&user.getPhone()!=null){
            userService.add(user);
            model.addAttribute("msg","新增用户成功,请去登录！");
        }else{
            model.addAttribute("msg","必填的信息不能为空，请重新填！");

        }


        return "Register";






    }



}

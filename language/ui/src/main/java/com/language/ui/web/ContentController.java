package com.language.ui.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/content")
public class ContentController {
    @GetMapping("/index")
    public String index(){
        return "index";
    }

    @GetMapping("/list")
    public String selectALL(){
        return "content_list";
    }


    @GetMapping("/languageMain")
    public String language(){
        return "language_main";
    }

}

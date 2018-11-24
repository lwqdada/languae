package com.language.ui.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/category")
public class DetailController {

    @GetMapping(value={"/平桂话","/八步话"})
    public String pinggui(){

        return "detail";
    }
}

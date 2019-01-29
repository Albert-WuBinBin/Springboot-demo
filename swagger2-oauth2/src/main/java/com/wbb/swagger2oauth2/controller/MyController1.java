package com.wbb.swagger2oauth2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController1 {
    @RequestMapping(value = "/success")
    public String success(){
        return "success";
    }
}

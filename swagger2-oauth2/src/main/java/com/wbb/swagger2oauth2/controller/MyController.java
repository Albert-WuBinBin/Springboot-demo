package com.wbb.swagger2oauth2.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class MyController {

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public Object test(){
        return "test";
    }
    @RequestMapping(value = "/test2",method = RequestMethod.GET)
    public Object test2(){
        return "test2";
    }
    @RequestMapping(value = "/test3",method = RequestMethod.GET)
    public Object test3(){
        return "test3";
    }
    @RequestMapping(value = "/test4",method = RequestMethod.GET)
    public Object test4(){
        return "test4";
    }
}

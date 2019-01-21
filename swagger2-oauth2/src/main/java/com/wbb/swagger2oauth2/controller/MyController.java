package com.wbb.swagger2oauth2.controller;


import org.springframework.security.access.prepost.PreAuthorize;
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
    @RequestMapping(value = "/user",method = RequestMethod.GET)
    @PreAuthorize("hasAnyRole('ROLE_USER')")
    public Object user(){
        return "user";
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @RequestMapping(value = "/admin",method = RequestMethod.GET)
    public Object admin(){
        return "admin";
    }
}
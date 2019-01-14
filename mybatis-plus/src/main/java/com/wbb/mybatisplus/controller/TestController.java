package com.wbb.mybatisplus.controller;

import com.wbb.mybatisplus.bean.User;
import com.wbb.mybatisplus.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@Slf4j
public class TestController {

    @Autowired
    UserMapper userMapper;

    @RequestMapping(value = "/list" , method = RequestMethod.GET)
    public Object selectAll(){
        return userMapper.selectList(null);
    }
    @RequestMapping(value = "/{id}" , method = RequestMethod.GET)
    public Object selectById(@PathVariable(value = "id")Integer id){
        return userMapper.selectById(id);
    }
    @RequestMapping(value = "/add" , method = RequestMethod.GET)
    public Object add(@ModelAttribute User user){
//        return userMapper.
        return null;
    }
    @RequestMapping(value = "/delete/{id}" , method = RequestMethod.GET)
    public Object delete(@PathVariable(value = "id")Integer id){
        return userMapper.deleteById(id);
    }

}

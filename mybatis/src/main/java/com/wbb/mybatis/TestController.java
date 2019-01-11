package com.wbb.mybatis;

import com.wbb.mybatis.bean.User;
import com.wbb.mybatis.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@Slf4j
public class TestController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/list" , method = RequestMethod.GET)
    public Object selectAll(){
        return userService.selectAll();
    }
    @RequestMapping(value = "/{id}" , method = RequestMethod.GET)
    public Object selectById(@PathVariable(value = "id")Integer id){
        return userService.selectById(id);
    }
    @RequestMapping(value = "/add" , method = RequestMethod.GET)
    public Object add(@ModelAttribute User user){
        return userService.add(user);
    }
    @RequestMapping(value = "/delete/{id}" , method = RequestMethod.GET)
    public Object delete(@PathVariable(value = "id")Integer id){
        return userService.deleteById(id);
    }

}

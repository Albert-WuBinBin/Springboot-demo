package com.wbb.mybatisplus.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.wbb.mybatisplus.bean.PersonInfo;
import com.wbb.mybatisplus.service.IPersonInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wbb
 * @since 2019-01-14
 */
@RestController
@RequestMapping("/personInfo")
public class PersonInfoController {

    @Autowired
    IPersonInfoService personInfoService;
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public Object list(){
        //条件查询
        EntityWrapper ew = new EntityWrapper(new PersonInfo());
//        Map params = new HashMap<>();
//        params.put("name","wbb");
//        ew.allEq(params);
//        ew.eq("name","wbb"); //等于
//        ew.ne("name","wbb"); //不等于
//        ew.gt("user_age",2); //gt大于,ge大于等于,lt小于，le小于等于
//        ew.between("user_age","1","3");//between,notBetween
//        ew.like("name","%w%");//like,notLike,likeLeft(%值),likeRight(值%)
//        ew.isNull("name"); isNull,isNotNull
//        ew.in("user_age", Arrays.asList(1,2,3));  //in,notIn
//        ew.groupBy("name");
//        ew.orderAsc(Arrays.asList("user_age"));
//        ew.orderDesc()
//        ew.orderBy("user_age",true);
//        ew.having()
        return personInfoService.selectList(ew);
    }
}


package com.wbb.rabbit.controller;

import com.wbb.rabbit.producer.RabbitMqProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rabbit")
@Slf4j
public class TestController {


    @Autowired
    RabbitMqProducer rabbitMqProducer ;

    @RequestMapping(value = "/direct" , method = RequestMethod.GET)
    public Object direct(@RequestParam("message")String message){
        rabbitMqProducer.sendDirectMessage(message);
        return "success";
    }
    @RequestMapping(value = "/fanout" , method = RequestMethod.GET)
    public Object fanout(@RequestParam("message")String message){
        rabbitMqProducer.sendFanoutMessage(message);
        return "success";
    }
    @RequestMapping(value = "/topic" , method = RequestMethod.GET)
    public Object topic(@RequestParam("message")String message){
        rabbitMqProducer.sendTopicMessage(message);
        return "success";
    }
}

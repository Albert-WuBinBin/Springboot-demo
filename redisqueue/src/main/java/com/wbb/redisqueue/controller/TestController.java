package com.wbb.redisqueue.controller;

import com.wbb.redisqueue.queue.RedisQueueProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/redis")
@Slf4j
public class TestController {

    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Autowired
    RedisQueueProducer redisQueueSender;
    @RequestMapping(value = "/get" , method = RequestMethod.GET)

    public Object redis(@RequestParam("name")String name) throws Exception {
        stringRedisTemplate.opsForValue().set("wbb",name);
        return stringRedisTemplate.opsForValue().get("wbb");
    }
    @RequestMapping(value = "/queue" , method = RequestMethod.GET)
    public Object redisQueue(@RequestParam("message")String message){
        redisQueueSender.sendMessage("topic1",message);
        redisQueueSender.sendMessage("topic2",message);
        return "success";
    }
}

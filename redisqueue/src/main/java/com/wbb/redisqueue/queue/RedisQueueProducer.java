package com.wbb.redisqueue.queue;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
/**
 * redis消息发送
 */
public class RedisQueueProducer {

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    public void sendMessage(String channel,String message){
        log.info("send message:" + message);
        stringRedisTemplate.convertAndSend(channel,message);
    }
}

package com.wbb.redisqueue.queue;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * redis队列接受者
 */
@Component
@Slf4j
public class RedisQueueConsumer {

    public void receiveMessage(String message){
        log.info("receive topic1:"+message);
    }
    public void handleMessage(String message){
        log.info("receive topic2:"+message);
    }
}

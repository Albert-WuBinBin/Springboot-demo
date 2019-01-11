package com.wbb.rabbit.consumer;

import com.wbb.rabbit.config.RabbitMqConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class RabbitMqConsumer {

    //direct
    @RabbitListener(queues = {RabbitMqConfig.DIRECT_QUEUE_A,RabbitMqConfig.DIRECT_QUEUE_B,RabbitMqConfig.DIRECT_QUEUE_C})
    public void handleMessage(Message message){
       log.info("receive message:"+message);
    }

    //fanout
    @RabbitListener(queues = RabbitMqConfig.FANOUT_QUEUE_A)
    public void handleMessage1(Message message){
        log.info("fanout_queue_a receive message:"+message);
    }
    @RabbitListener(queues = RabbitMqConfig.FANOUT_QUEUE_B)
    public void handleMessage2(Message message){
        log.info("fanout_queue_b receive message:"+message);
    }
    @RabbitListener(queues = RabbitMqConfig.FANOUT_QUEUE_C)
    public void handleMessage3(Message message){
        log.info("fanout_queue_c receive message:"+message);
    }

    //topic
    @RabbitListener(queues = RabbitMqConfig.TOPIC_QUEUE_A)
    public void handleMessage4(Message message){
        log.info("topic_queue_a receive message:"+message);
    }
    @RabbitListener(queues = RabbitMqConfig.TOPIC_QUEUE_B)
    public void handleMessage5(Message message){
        log.info("topic_queue_b receive message:"+message);
    }
}

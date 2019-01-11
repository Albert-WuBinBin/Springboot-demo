package com.wbb.rabbit.producer;

import com.wbb.rabbit.config.RabbitMqConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Slf4j
public class RabbitMqProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate ;

    public void sendDirectMessage(String message){
        CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
        rabbitTemplate.convertAndSend(RabbitMqConfig.DIRECT_EXCHANGE_A,RabbitMqConfig.DIRECT_ROUNTING_A,message,correlationData);
    }
    public void sendFanoutMessage(String message){
        CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
        rabbitTemplate.convertAndSend(RabbitMqConfig.FANOUT_EXCHANGE_A,"",message,correlationData);
    }
    public void sendTopicMessage(String message){
        CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
        rabbitTemplate.convertAndSend(RabbitMqConfig.TOPIC_EXCHANGE_A,RabbitMqConfig.TOPIC_QUEUE_A,message,correlationData);
    }
}

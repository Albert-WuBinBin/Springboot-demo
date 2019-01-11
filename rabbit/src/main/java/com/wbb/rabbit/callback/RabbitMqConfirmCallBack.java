package com.wbb.rabbit.callback;


import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.lang.Nullable;

@Slf4j
public class RabbitMqConfirmCallBack implements RabbitTemplate.ConfirmCallback{
    @Override
    public void confirm(@Nullable CorrelationData correlationData, boolean ack, @Nullable String s) {
        log.info(" 回调id:" + correlationData);
        if (ack) {
            log.info("消息成功消费");
        } else {
            log.info("消息消费失败:" + s);
        }
    }
}

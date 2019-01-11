package com.wbb.rabbit.config;


import com.wbb.rabbit.callback.RabbitMqConfirmCallBack;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class RabbitMqConfig {

    public static final String DIRECT_EXCHANGE_A = "direct_exchange_a";
    public static final String DIRECT_QUEUE_A = "direct_queue_a";
    public static final String DIRECT_QUEUE_B = "direct_queue_b";
    public static final String DIRECT_QUEUE_C = "direct_queue_c";
    public static final String DIRECT_ROUNTING_A = "direct_rounting_a";


    public static final String FANOUT_EXCHANGE_A = "fanout_exchange_a";
    public static final String FANOUT_QUEUE_A = "fanout_queue_a";
    public static final String FANOUT_QUEUE_B= "fanout_queue_b";
    public static final String FANOUT_QUEUE_C = "fanout_queue_c";

    public static final String TOPIC_EXCHANGE_A = "topic_exchange_a";
    public static final String TOPIC_QUEUE_A = "topic.queue_a";
    public static final String TOPIC_QUEUE_B= "topic.queue_b";
    public static final String TOPIC_QUEUE_C = "topic.queue_c";

    @Autowired
    ConnectionFactory connectionFactory;
    @Autowired
    RabbitMqQueueConfig rabbitMqQueueConfig;
    @Autowired
    RabbitMqExchangeConfig rabbitMqExchangeConfig;
    @Bean
    public RabbitTemplate rabbitTemplate(){
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        template.setConfirmCallback(new RabbitMqConfirmCallBack());
        return template;
    }

    @Bean
    public Binding bindingA(){
        return BindingBuilder.bind(rabbitMqQueueConfig.directQueueA()).to(rabbitMqExchangeConfig.directExchangeA()).with(DIRECT_ROUNTING_A);
    }

    @Bean
    public Binding fanoutBindingA(){
        return BindingBuilder.bind(rabbitMqQueueConfig.fanoutQueueA()).to(rabbitMqExchangeConfig.fanoutExchangeA());
    }
    @Bean
    public Binding fanoutBindingB(){
        return BindingBuilder.bind(rabbitMqQueueConfig.fanoutQueueB()).to(rabbitMqExchangeConfig.fanoutExchangeA());
    }
    @Bean
    public Binding fanoutBindingC(){
        return BindingBuilder.bind(rabbitMqQueueConfig.fanoutQueueC()).to(rabbitMqExchangeConfig.fanoutExchangeA());
    }

    @Bean
    public Binding topicBindingA(){
        return BindingBuilder.bind(rabbitMqQueueConfig.topicQueueA()).to(rabbitMqExchangeConfig.topicExchangeA()).with(RabbitMqConfig.TOPIC_QUEUE_A);
    }
    @Bean
    public Binding topicBindingB(){
        return BindingBuilder.bind(rabbitMqQueueConfig.topicQueueB()).to(rabbitMqExchangeConfig.topicExchangeA()).with("topic.#");
    }
    /**
     * 消息确认机制
     * Confirms给客户端一种轻量级的方式，能够跟踪哪些消息被broker处理，
     * 哪些可能因为broker宕掉或者网络失败的情况而重新发布。
     * 确认并且保证消息被送达，提供了两种方式：发布确认和事务。(两者不可同时使用)
     * 在channel为事务时，不可引入确认模式；同样channel为确认模式下，不可使用事务。
     * @return
     */
    @Bean
    public RabbitMqConfirmCallBack msgSendConfirmCallBack(){
        return new RabbitMqConfirmCallBack();
    }
}

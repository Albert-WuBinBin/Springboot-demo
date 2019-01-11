package com.wbb.rabbit.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 队列配置 可以配置多个队列
 */
@Configuration
public class RabbitMqQueueConfig {


    /**
     durable="true" 持久化 rabbitmq重启的时候不需要创建新的队列
     auto-delete 表示消息队列没有在使用时将被自动删除 默认是false
     exclusive  表示该消息队列是否只在当前connection生效,默认是false
     */
    @Bean
    public Queue directQueueA(){
        return new Queue(RabbitMqConfig.DIRECT_QUEUE_A,false,false,true);
    }
    @Bean
    public Queue directQueueB(){
        return new Queue(RabbitMqConfig.DIRECT_QUEUE_B);
    }
    @Bean
    public Queue directQueueC(){
        return new Queue(RabbitMqConfig.DIRECT_QUEUE_C);
    }

    @Bean
    public Queue fanoutQueueA(){
        return new Queue(RabbitMqConfig.FANOUT_QUEUE_A);
    }
    @Bean
    public Queue fanoutQueueB(){
        return new Queue(RabbitMqConfig.FANOUT_QUEUE_B);
    }
    @Bean
    public Queue fanoutQueueC(){
        return new Queue(RabbitMqConfig.FANOUT_QUEUE_C);
    }

    @Bean
    public Queue topicQueueA(){
        return new Queue(RabbitMqConfig.TOPIC_QUEUE_A);
    }
    @Bean
    public Queue topicQueueB(){
        return new Queue(RabbitMqConfig.TOPIC_QUEUE_B);
    }
    @Bean
    public Queue topicQueueC(){
        return new Queue(RabbitMqConfig.TOPIC_QUEUE_C);
    }

}

package com.wbb.rabbit.config;


import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 *  消息交换机配置 可以配置多个
 */
@Configuration
public class RabbitMqExchangeConfig {

    /** 几种exchange
     * fanout	fanout交换器中没有路由键的概念，他会把消息发送到所有绑定在此交换器上面的队列中。
     * direct	direct交换器相对来说比较简单，匹配规则为：如果路由键匹配，消息就被投送到相关的队列
     * topic	topic交换器你采用模糊匹配路由键的原则进行转发消息到队列中
     * headers	Exchange根据发送的消息内容中的headers属性进行匹配。
     */
    @Bean
    public DirectExchange directExchangeA(){
        /**
         *  durable="true" rabbitmq重启的时候不需要创建新的交换机
         */
        return new DirectExchange(RabbitMqConfig.DIRECT_EXCHANGE_A,true,false);
    }

    @Bean
    public FanoutExchange fanoutExchangeA(){
        return new FanoutExchange(RabbitMqConfig.FANOUT_EXCHANGE_A);
    }


    @Bean
    public TopicExchange topicExchangeA(){
        return new TopicExchange(RabbitMqConfig.TOPIC_EXCHANGE_A);
    }
}

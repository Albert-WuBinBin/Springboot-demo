package com.wbb.redisqueue.queue;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;


/**
 * redis队列配置
 */
@Configuration
@Slf4j
public class RedisQueueConfig {

    @Autowired
    RedisConnectionFactory factory;
    @Autowired
    @Qualifier(value = "adapter1")
    MessageListenerAdapter adapter1;
    @Autowired
    @Qualifier(value = "adapter2")
    MessageListenerAdapter adapter2;
    //初始化监听容器,可以监听多个MessageListenerAdapter和多个topic
    @Bean
    RedisMessageListenerContainer container(){
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(factory);
        container.addMessageListener(adapter1,new PatternTopic("topic1"));
        container.addMessageListener(adapter2,new PatternTopic("topic2"));
        return container;
    }
    //监听收到消息后的执行方法，默认handleMessage
   @Bean(value = "adapter1")
   MessageListenerAdapter listenerAdapter1(RedisQueueConsumer consumer){
        return new MessageListenerAdapter(consumer,"receiveMessage");
   }
    @Bean(value = "adapter2")
    MessageListenerAdapter listenerAdapter2(RedisQueueConsumer consumer){
        return new MessageListenerAdapter(consumer);
    }
    //使用默认的工厂初始化redis操作模板
    @Bean
   StringRedisTemplate stringRedisTemplate(){
            return new StringRedisTemplate(factory);
    }

}

package com.wbb.redisqueue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.wbb")
public class RedisqueueApplication {

	public static void main(String[] args) {
		SpringApplication.run(RedisqueueApplication.class, args);
	}

}


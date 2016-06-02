package com.daphne.lazulite;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.connection.jedis.JedisConnection;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfiguration;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import javax.jms.Queue;
import java.util.concurrent.Executor;

@SpringBootApplication
@EnableCaching
@EnableScheduling
@EnableJms
public class LazuliteApplication  {

	public static void main(String[] args) {
		SpringApplication.run(LazuliteApplication.class, args);
	}
	@Bean
	public Queue queue() {
		return new ActiveMQQueue("sample.queue");
	}


	@Bean
	public TaskScheduler taskScheduler(){
		TaskScheduler taskScheduler=new ThreadPoolTaskScheduler();
		return taskScheduler;
	}

}

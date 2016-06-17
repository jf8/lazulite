package com.daphne.lazulite;

import com.daphne.lazulite.wechat.WechatProperties;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

import javax.jms.Queue;

@SpringBootApplication
@EnableCaching
@EnableScheduling
@EnableJms
@EnableConfigurationProperties(WechatProperties.class)
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

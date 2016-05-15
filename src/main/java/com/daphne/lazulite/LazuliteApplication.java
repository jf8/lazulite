package com.daphne.lazulite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfiguration;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import java.util.concurrent.Executor;

@SpringBootApplication
@EnableCaching
@EnableScheduling
public class LazuliteApplication {

	public static void main(String[] args) {
		SpringApplication.run(LazuliteApplication.class, args);
	}


	@Bean
	public TaskScheduler taskScheduler(){
		TaskScheduler taskScheduler=new ThreadPoolTaskScheduler();
		return taskScheduler;
	}
}

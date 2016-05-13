package com.daphne.lazulite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
@EnableGlobalMethodSecurity(prePostEnabled=true,securedEnabled = true,proxyTargetClass = true)
public class LazuliteApplication  {

	public static void main(String[] args) {
		SpringApplication.run(LazuliteApplication.class, args);
	}




}

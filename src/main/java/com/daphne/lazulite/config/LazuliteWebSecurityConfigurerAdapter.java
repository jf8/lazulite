/*
 * Copyright (c) 2016. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.daphne.lazulite.config;

import com.daphne.lazulite.sys.user.handler.LoginSuccessHandler;
import com.daphne.lazulite.sys.user.service.LazuliteUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

import javax.sql.DataSource;

/**
 * Created by junfu on 2016/5/5.
 */
@Configuration
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class LazuliteWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/h2-console/**").permitAll()
                .anyRequest()
                    .fullyAuthenticated()
                .and()
                .formLogin()
                    .loginPage("/login")
                    .failureUrl("/login?error")
                    .successHandler(loginSuccessHandler())
                    .permitAll()
                .and()
                .rememberMe()
                    .tokenValiditySeconds(1209600)
                    .key("myKey")
                .and()
                .logout()
                    .logoutUrl("/logout")
                    .logoutSuccessUrl("/login?logout")
                    .permitAll()
             /*   .and()
                    .requiresChannel()
                    .antMatchers("/login")
                    .requiresSecure()*/
                .and()
                .csrf()
                    .disable()
                .headers()
                    .frameOptions().sameOrigin();

    }


    @Bean
    public LoginSuccessHandler loginSuccessHandler(){
        return new LoginSuccessHandler();
    }
    @Bean
    public LazuliteUserDetailsService lazuliteUserDetailsService(){
        return new LazuliteUserDetailsService();
    }
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(lazuliteUserDetailsService())
            .passwordEncoder(new StandardPasswordEncoder("123"));
//        auth.jdbcAuthentication().dataSource(this.dataSource).usersByUsernameQuery("" +
//                "select username,password,enabled,email from sys_user where username = ?").authoritiesByUsernameQuery("" +
//                "select username,authority from sys_authorities where username = ? ");
    }
}

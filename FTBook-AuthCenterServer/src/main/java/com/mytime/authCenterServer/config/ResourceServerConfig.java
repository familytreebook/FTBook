package com.mytime.authCenterServer.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

/**
 * 优先级默认是3
 * 比WebSecurityConfig大
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
//                antMatcher表示只能处理/oauth2_token的请求
                .antMatcher("/oauth2_token/**")
                .authorizeRequests()
                .anyRequest().authenticated()
        ;
    }
}

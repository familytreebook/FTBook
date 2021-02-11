package com.mytime.platform.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import feign.Retryer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.TimeUnit;

@Configuration
public class FeignConfig implements RequestInterceptor {
    private final String AUTHORIZATION_HEADER = "Authorization";
    private final String BEARER_TOKEN_TYPE = "Bearer";

 /*   @Bean
    public Retryer feignRetryer() {
        *//*
         * 参数说明：
         * 第一个> 重试间隔为100毫秒
         * 第二个> 最大重试时间为1秒
         * 第三个> 最大重试次数为5次
         *//*
        return new Retryer.Default(100, TimeUnit.SECONDS.toMillis(1), 5);
    }*/
   @Override
    public void apply(RequestTemplate requestTemplate) {
       SecurityContext securityContext = SecurityContextHolder.getContext();
       Authentication authentication = securityContext.getAuthentication();
       if (authentication != null && authentication.getDetails() instanceof OAuth2AuthenticationDetails) {
           OAuth2AuthenticationDetails details = (OAuth2AuthenticationDetails) authentication.getDetails();
           System.out.println(details.getTokenValue());
           String auth = String.format("%s %s", BEARER_TOKEN_TYPE, details.getTokenValue());
           System.out.println(auth);
           requestTemplate.header(AUTHORIZATION_HEADER, auth);
           requestTemplate.header("x-requested-with","XMLHttpRequest");
       }

    }
}

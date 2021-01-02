package com.mytime.Zuul.ZuulServer.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.boot.autoconfigure.security.oauth2.client.OAuth2SsoProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.Http403ForbiddenEntryPoint;

@EnableOAuth2Sso
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private ApplicationContext applicationContext;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        OAuth2SsoProperties sso = this.applicationContext
                .getBean(OAuth2SsoProperties.class);
        http.anonymous().disable()
//                .formLogin().permitAll()
//                .and()
                .authorizeRequests()
                .antMatchers("/login").permitAll()
                .anyRequest().authenticated()
                .and().csrf().disable()
                .exceptionHandling()
                .authenticationEntryPoint(new MyZuulForbiddenEntryPoint(sso.getLoginPath()))
        ;
    }
}

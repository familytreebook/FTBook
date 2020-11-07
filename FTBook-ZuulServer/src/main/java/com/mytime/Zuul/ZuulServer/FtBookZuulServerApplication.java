package com.mytime.Zuul.ZuulServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableZuulProxy
public class FtBookZuulServerApplication {
//http://localhost:8103/actuator/routes
	@ConfigurationProperties("zuul")
	public ZuulProperties zuulProperties() {
		return new ZuulProperties();
	}
	public static void main(String[] args) {
		SpringApplication.run(FtBookZuulServerApplication.class, args);
	}

	@Bean
	public AccessFilter accessPasswordFilter(){
		return new AccessFilter();
	}
}

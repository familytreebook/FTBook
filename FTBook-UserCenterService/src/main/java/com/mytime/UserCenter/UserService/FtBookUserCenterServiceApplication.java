package com.mytime.UserCenter.UserService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient

public class FtBookUserCenterServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FtBookUserCenterServiceApplication.class, args);
	}
	
}

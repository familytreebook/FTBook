package com.mytime.authCenterServer;

import org.springframework.boot.SpringApplication;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.mytime.authCenterServer.mapper")
public class FTBookAuthCenterServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(FTBookAuthCenterServerApplication.class, args);
	}

}

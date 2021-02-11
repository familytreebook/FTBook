package com.mytime.UserCenter;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@ComponentScan(basePackages = {"com.mytime.*"})
@MapperScan("com.mytime.UserCenter.basic.mapper")
public class FtBookUserCenterServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FtBookUserCenterServiceApplication.class, args);
	}
	
}

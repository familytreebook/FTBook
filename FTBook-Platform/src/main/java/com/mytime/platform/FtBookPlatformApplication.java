package com.mytime.platform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
public class FtBookPlatformApplication {

	public static void main(String[] args) {
		SpringApplication.run(FtBookPlatformApplication.class, args);
	}

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {

		RestTemplate restTemplate = new RestTemplate();

		return restTemplate;
	}
}

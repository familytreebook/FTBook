package com.mytime.Zuul.APIZuulServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class FtBookApiZuulServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(FtBookApiZuulServerApplication.class, args);
	}

}

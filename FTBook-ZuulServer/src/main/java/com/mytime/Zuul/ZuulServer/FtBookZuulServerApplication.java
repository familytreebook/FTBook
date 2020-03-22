package com.mytime.Zuul.ZuulServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class FtBookZuulServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(FtBookZuulServerApplication.class, args);
	}

}

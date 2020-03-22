package com.mytime.ConfigCenter.ConfigCenterServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class FtBookConfigCenterServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(FtBookConfigCenterServerApplication.class, args);
	}

}

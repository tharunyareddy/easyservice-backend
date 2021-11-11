package com.easyservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class EasyserviceConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EasyserviceConfigServerApplication.class, args);
	}

}

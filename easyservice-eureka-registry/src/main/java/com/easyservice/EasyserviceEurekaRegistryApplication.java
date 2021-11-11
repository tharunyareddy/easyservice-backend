package com.easyservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EasyserviceEurekaRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(EasyserviceEurekaRegistryApplication.class, args);
	}

}

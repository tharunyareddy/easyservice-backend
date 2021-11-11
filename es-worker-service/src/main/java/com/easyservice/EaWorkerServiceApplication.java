package com.easyservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import com.easyservice.service.IWorkerService;

@SpringBootApplication
@EnableEurekaClient
public class EaWorkerServiceApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(EaWorkerServiceApplication.class, args);
	}
	
	@Autowired
	IWorkerService workService;

	@Override
	public void run(String... args) throws Exception {
//		System.out.println(workService.getByWorkerName("Ram"));
//		System.out.println(workService.getByStatusAndWorkType("NA","InteriorPainting"));
//		System.out.println(workService.getByDurationAndWorkType(8,"InteriorPainting"));
		
	}

}

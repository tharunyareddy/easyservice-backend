package com.easyservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


import com.easyservice.service.IMaintenanceService;

@SpringBootApplication
@EnableEurekaClient
public class EasyserviceProjectRestapiApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(EasyserviceProjectRestapiApplication.class, args);
	}

	@Autowired
	IMaintenanceService maintenanceService;
	
	
	@Override
	public void run(String... args) throws Exception {
//    	LocalDate startDate=LocalDate.parse("2021-10-07");
//		LocalDate endDate=LocalDate.parse("2021-10-11");
//		
//		Status status=Status.valueOf("COMPLETED");
//		Priority priority=Priority.valueOf("HIGH");
//		
		//Task task=new Task("Painting","Ayan",startDate,endDate,4,status);
		
//		
//    	Maintenance maintain=new Maintenance("Mysore Palace","Sai",startDate,endDate,status,priority);
//	    maintenanceService.addMaintenance(maintain);
		
		//System.out.println(maintenanceService.getByContractId(17));
	}
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
		
	}

}

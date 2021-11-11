package com.easyservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.easyservice.service.ITaskService;

@SpringBootApplication
@EnableEurekaClient
public class EasyserviceProjectRestapiApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(EasyserviceProjectRestapiApplication.class, args);

	}

	@Autowired
	ITaskService taskService;
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Override
	public void run(String... args) throws Exception {
		//taskService.getAllTask().forEach(System.out::println);
		// task
//		LocalDate tStartDate = LocalDate.of(2021,10,9);
//		LocalDate tEndDate = LocalDate.of(2021,10,10);
//		Status tStatus = Status.valueOf("INPROGRESS");
//		Task task = new Task("InteriorPainting", "Ayan", tStartDate, tEndDate, 6, tStatus);
		// taskService.addTask(task);
		// Set<Task> taskList=new HashSet<>(Arrays.asList(task));

		// Maintenance
//		LocalDate mStartDate = LocalDate.of(2021,10,1);
//		LocalDate mEndDate = LocalDate.of(2021,10,10);
//		Status mStatus=Status.valueOf("INPROGRESS");
//		Priority mPriority=Priority.valueOf("HIGH");
//		Maintenance maintenance=new Maintenance("Painting","Tom",mStartDate , mEndDate, mStatus, mPriority, null);
		// Set<Maintenance> maintenanceList=new HashSet<>(Arrays.asList(maintenance));

		// Contractor
//		LocalDate cStartDate = LocalDate.of(2021,10,1);
//		LocalDate cEndDate = LocalDate.of(2021,11,1);
//		Contractor contractor=new Contractor("Mysore Palace","Nesamani",cStartDate, cEndDate,null);
		// taskService.assignTaskToWorker(300, 200);
		//taskService.updateStatus("NA", 300);
	}

}

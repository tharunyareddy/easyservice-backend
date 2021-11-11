/**
 *
 */
package com.easyservice;

/**
 * @author TharunyaREDDY
 *
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.easyservice.service.IContractorService;

@SpringBootApplication
@EnableEurekaClient
public class EsContractServiceApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(EsContractServiceApplication.class, args);
	}

	@Autowired
	IContractorService contractorService;

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	@Override
	public void run(String... args) throws Exception {

		
	}

}

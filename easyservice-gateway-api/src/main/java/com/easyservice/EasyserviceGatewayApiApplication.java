package com.easyservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class EasyserviceGatewayApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(EasyserviceGatewayApiApplication.class, args);
	}

	@Bean
	public RouteLocator customRoutes(RouteLocatorBuilder builder) {
		return builder.routes()
				.route("contractAPI", r -> r.path("/contractor-service/**").uri("http://localhost:8070"))
				.route("maintenanceAPI",
						r -> r.path("/maintenance-service/**")
								.filters(f -> f.addRequestHeader("desc", "maintenance added").addResponseHeader("result",
										"Showing Maintenance details"))
								.uri("http://localhost:8071"))
				.route("taskAPI",
						r -> r.path("/task-service/**")
								.filters(f -> f.addRequestHeader("desc", "task added")
										.addResponseHeader("result", "task details"))
								.uri("http://localhost:8072"))
				.route("workerAPI",
						r -> r.path("/work-service/**")
								.filters(f -> f.addRequestHeader("desc", "work added")
										.addResponseHeader("result", "task details"))
								.uri("http://localhost:8073"))
				.build();

	}

}

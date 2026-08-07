package com.microservice.service_A;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class ServiceAApplication {

	@Bean
	public WebClient.Builder webclient(){
		return WebClient.builder();
	}

	public static void main(String[] args) {
		SpringApplication.run(ServiceAApplication.class, args);
	}



}

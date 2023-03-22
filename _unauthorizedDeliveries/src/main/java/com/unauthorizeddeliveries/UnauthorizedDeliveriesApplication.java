package com.unauthorizeddeliveries;

import com.unauthorizeddeliveries.services.ExelUploadService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

//main configuration(include @EnableAutoConfiguration, @Import(importSelector))
@SpringBootApplication
public class UnauthorizedDeliveriesApplication {

	public static void main(String[] args) {

		SpringApplication.run(UnauthorizedDeliveriesApplication.class, args);

		getExelUploadService();
	}


	@Bean
	public static ExelUploadService getExelUploadService(){

		return new ExelUploadService();
	}


}

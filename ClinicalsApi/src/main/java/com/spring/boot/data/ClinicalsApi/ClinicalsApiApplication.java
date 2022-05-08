package com.spring.boot.data.ClinicalsApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class ClinicalsApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClinicalsApiApplication.class, args);
	}

}

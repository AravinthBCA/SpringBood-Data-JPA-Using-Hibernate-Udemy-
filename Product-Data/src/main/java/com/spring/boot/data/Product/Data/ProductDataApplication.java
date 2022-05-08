package com.spring.boot.data.Product.Data;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class ProductDataApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductDataApplication.class, args);
	}

}

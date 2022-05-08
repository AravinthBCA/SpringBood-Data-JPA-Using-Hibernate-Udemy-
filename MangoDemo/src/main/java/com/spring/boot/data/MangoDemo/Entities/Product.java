package com.spring.boot.data.MangoDemo.Entities;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class Product {

	private String id;
	private String name;
	private String description;
	private int price;
	
}

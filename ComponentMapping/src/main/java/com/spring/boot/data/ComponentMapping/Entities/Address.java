package com.spring.boot.data.ComponentMapping.Entities;

import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class Address {

	private String streetaddress;
	private String city;
	private String state;
	private String zipcode;
	private String country;
	
}

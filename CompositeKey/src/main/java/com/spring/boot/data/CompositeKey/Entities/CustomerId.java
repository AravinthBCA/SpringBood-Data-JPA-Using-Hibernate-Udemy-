package com.spring.boot.data.CompositeKey.Entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable  //this for embedded ways implementation
public class CustomerId implements Serializable{

	private int id;
	private String email;
	
}

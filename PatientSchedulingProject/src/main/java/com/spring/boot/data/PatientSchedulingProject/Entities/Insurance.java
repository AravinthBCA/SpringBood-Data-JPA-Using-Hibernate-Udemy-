package com.spring.boot.data.PatientSchedulingProject.Entities;

import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class Insurance {

	private String providerName;
	private double copay;
	
}

package com.spring.boot.data.ClinicalsApi.dto;

import lombok.Data;

@Data
public class ClinicalDataRequest {

	private String componentName;
	private String componentValue;
	private int patientId;
	
}

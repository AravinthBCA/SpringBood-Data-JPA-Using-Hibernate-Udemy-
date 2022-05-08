package com.spring.boot.data.ClinicalsApi.Entities;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@Entity
@Table(name="clinicaldata")
@JsonIgnoreProperties({"patient"}) //not mention means it goes to loop
//above annotation for whenever you retrieve patient object it has the clinicalData list and the list have another patient
//that patient have clinicalData list that list have another patient it goest into loop so you told to skip patient object in
//clinicalData class otherwise you can delete it
public class ClinicalData {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="component_name")
	private String componentName;
	@Column(name="component_value")
	private String componentValue;
	@Column(name="measured_date_time")
	private Timestamp measuredDateTime;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="patient_id",nullable=false)
	private Patient patient;
}

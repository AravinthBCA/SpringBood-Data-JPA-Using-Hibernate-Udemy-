package com.spring.boot.data.PatientSchedulingProject.Entities;

import java.sql.Timestamp;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
public class Appointment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Timestamp appointmentTime;
	private Boolean started;
	private boolean ended;
	private String reason;
	
	@ManyToOne
	private Patient patient;
	
	@ManyToOne
	private Doctor doctor;
}

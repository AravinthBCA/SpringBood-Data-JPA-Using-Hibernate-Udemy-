package com.spring.boot.data.PatientSchedulingProject.Entities;

import java.util.List;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
public class Doctor {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name="first_name")
	private String firstName;
	@Column(name="last_name")
	private String lastName;
	private String speciality;
	
	@ManyToMany(mappedBy="doctors")
	List<Patient> patients;
	
	@OneToMany
	private List<Appointment> appointments;

	
}

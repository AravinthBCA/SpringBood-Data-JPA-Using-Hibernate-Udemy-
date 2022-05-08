package com.spring.boot.data.PatientSchedulingProject.Entities;

import java.util.List;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
public class Patient {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String firstName;
	private String lastName;
	private String phone;
	
	@Embedded
	private Insurance insurance;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="patients_doctors",
	joinColumns=@JoinColumn(name="patient_id",referencedColumnName="id"),
	inverseJoinColumns=@JoinColumn(name="doctor_id",referencedColumnName="id"))
	List<Doctor> doctors;
	
	@OneToMany
	private List<Appointment> appointments;
}

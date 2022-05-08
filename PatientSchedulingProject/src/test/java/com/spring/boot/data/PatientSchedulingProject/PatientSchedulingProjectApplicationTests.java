package com.spring.boot.data.PatientSchedulingProject;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.spring.boot.data.PatientSchedulingProject.Entities.Appointment;
import com.spring.boot.data.PatientSchedulingProject.Entities.Doctor;
import com.spring.boot.data.PatientSchedulingProject.Entities.Insurance;
import com.spring.boot.data.PatientSchedulingProject.Entities.Patient;
import com.spring.boot.data.PatientSchedulingProject.Repos.AppointmentRepository;
import com.spring.boot.data.PatientSchedulingProject.Repos.DoctorRepository;
import com.spring.boot.data.PatientSchedulingProject.Repos.PatientRepository;

@SpringBootTest
class PatientSchedulingProjectApplicationTests {

	@Autowired
	DoctorRepository doctorRepo;
	
	@Autowired
	PatientRepository patientRepo;
	
	@Autowired
	AppointmentRepository appointRepo;
	
//	@Test
	void testcreateDoctor() {
		Doctor doctor = new Doctor();
		doctor.setFirstName("aravinth");
		doctor.setLastName("kaliyamoorthy");
		doctor.setSpeciality("All");
		doctorRepo.save(doctor);
	}
	
//	@Test
	public void testCreatePatient() {
		Patient patient = new Patient();
		patient.setFirstName("Doug");
		patient.setLastName("Bailey");
		patient.setPhone("12345");
		
		Insurance insurance = new Insurance();
		insurance.setProviderName("Sample");
		insurance.setCopay(20D);
		
		patient.setInsurance(insurance);
		
		Doctor doctor = doctorRepo.findById(45L).get(); 
		List<Doctor> doctors = Arrays.asList(doctor);
		patient.setDoctors(doctors);
		
		patientRepo.save(patient);
	}
	
	@Test
	public void testCreateAppointment() {
		Appointment appoint = new Appointment();
		Timestamp appointTime = new Timestamp(new Date().getTime());
		appoint.setAppointmentTime(appointTime);
		appoint.setReason("I have a problem");
		appoint.setStarted(true);
		appoint.setPatient(patientRepo.findById((long) 47).get());
		appoint.setDoctor(doctorRepo.findById(45L).get());
		appointRepo.save(appoint);
	}

}

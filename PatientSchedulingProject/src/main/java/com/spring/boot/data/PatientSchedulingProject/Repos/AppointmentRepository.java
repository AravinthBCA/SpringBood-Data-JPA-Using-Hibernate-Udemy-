package com.spring.boot.data.PatientSchedulingProject.Repos;

import org.springframework.data.repository.CrudRepository;

import com.spring.boot.data.PatientSchedulingProject.Entities.Appointment;
import com.spring.boot.data.PatientSchedulingProject.Entities.Doctor;

public interface AppointmentRepository extends CrudRepository<Appointment, Long>{

}

package com.spring.boot.data.PatientSchedulingProject.Repos;

import org.springframework.data.repository.CrudRepository;

import com.spring.boot.data.PatientSchedulingProject.Entities.Doctor;

public interface DoctorRepository extends CrudRepository<Doctor, Long> {

}

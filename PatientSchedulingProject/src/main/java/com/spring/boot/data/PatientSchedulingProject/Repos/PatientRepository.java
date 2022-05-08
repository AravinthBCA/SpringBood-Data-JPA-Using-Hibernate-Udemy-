package com.spring.boot.data.PatientSchedulingProject.Repos;

import org.springframework.data.repository.CrudRepository;

import com.spring.boot.data.PatientSchedulingProject.Entities.Patient;

public interface PatientRepository extends CrudRepository<Patient,Long>{

}

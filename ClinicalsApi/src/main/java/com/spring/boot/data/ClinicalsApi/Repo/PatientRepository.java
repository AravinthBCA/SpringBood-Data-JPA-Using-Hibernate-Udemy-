package com.spring.boot.data.ClinicalsApi.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.spring.boot.data.ClinicalsApi.Entities.Patient;

public interface PatientRepository extends JpaRepository<Patient, Integer> {
	
	

}

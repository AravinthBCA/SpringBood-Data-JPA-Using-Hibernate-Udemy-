package com.spring.boot.data.ClinicalsApi.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.spring.boot.data.ClinicalsApi.Entities.ClinicalData;

public interface ClinicalDataRepository extends JpaRepository<ClinicalData, Integer> {
	
	@Query(value="select max(patient_id) from clinicaldata where patient_id=:id",nativeQuery=true)
	ClinicalData findClinicalData(@Param("id") int id);
	
}

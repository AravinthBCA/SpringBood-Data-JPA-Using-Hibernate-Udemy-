package com.spring.boot.data.ClinicalsApi.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.spring.boot.data.ClinicalsApi.Entities.ClinicalData;

public interface ClinicalDataRepository extends JpaRepository<ClinicalData, Integer> {
	
//	@Query(value ="CALL  get (:comp_name,:pat_id)", nativeQuery = true)
//	ClinicalData findMaxClinicalDataByPatientIdAndComponentName(String comp_name,int pat_id);
	 
	//you can use below or above one both are same purpose and same work they doing
	
	@Query(value ="select max(c.id) as id,c.patient_id,component_name,component_value,measured_date_time from clinicaldata c inner join \r\n"
			+ "patient p on p.id=c.patient_id where component_name = :comp_name and patient_id = :pat_id"
			+ "", nativeQuery = true)
	ClinicalData findMaxClinicalDataByPatientIdAndComponentName(@Param("comp_name") String comp_name,@Param("pat_id") int pat_id);

}

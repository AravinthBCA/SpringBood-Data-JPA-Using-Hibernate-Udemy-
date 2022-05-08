package com.spring.boot.data.ClinicalsApi.Controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.data.ClinicalsApi.Entities.ClinicalData;
import com.spring.boot.data.ClinicalsApi.Entities.Patient;
import com.spring.boot.data.ClinicalsApi.Repo.ClinicalDataRepository;
import com.spring.boot.data.ClinicalsApi.Repo.PatientRepository;
import com.spring.boot.data.ClinicalsApi.dto.ClinicalDataRequest;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ClinicalDataController {

	private ClinicalDataRepository clinicalDataRepo;
	private PatientRepository patientRepo;
	
	ClinicalDataController(ClinicalDataRepository clinicalDataRepo,PatientRepository patientRepo){
		this.clinicalDataRepo = clinicalDataRepo;
		this.patientRepo = patientRepo;
	}
	
	@RequestMapping(value = "/clinicals", method = RequestMethod.POST)
	public ClinicalData saveClinicalData(@RequestBody ClinicalDataRequest request) {
		Patient patient = patientRepo.findById(request.getPatientId()).get();
		ClinicalData clinicalData = new ClinicalData();
		clinicalData.setComponentName(request.getComponentName());;
		clinicalData.setComponentValue(request.getComponentValue());;
		clinicalData.setPatient(patient);
		return clinicalDataRepo.save(clinicalData);
	}
	
}

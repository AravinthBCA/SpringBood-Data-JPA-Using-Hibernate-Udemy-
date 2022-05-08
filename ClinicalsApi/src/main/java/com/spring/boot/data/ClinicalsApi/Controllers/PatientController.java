package com.spring.boot.data.ClinicalsApi.Controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.data.ClinicalsApi.Entities.ClinicalData;
import com.spring.boot.data.ClinicalsApi.Entities.Patient;
import com.spring.boot.data.ClinicalsApi.Repo.ClinicalDataRepository;
import com.spring.boot.data.ClinicalsApi.Repo.PatientRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class PatientController {

	private PatientRepository patientRepo;
	
	private ClinicalDataRepository clinicalRepo;

	Map<String,ClinicalData> filters = new HashMap<>();
	
	@Autowired
	PatientController(PatientRepository patientRepo, ClinicalDataRepository clinicalRepo) {
		this.patientRepo = patientRepo;
		this.clinicalRepo = clinicalRepo;
	}

	@RequestMapping(value = "/patients", method = RequestMethod.GET)
	@Transactional
	public List<Patient> getPatient() {
		return patientRepo.findAll();
	}

	@RequestMapping(value = "/patients/{id}", method = RequestMethod.GET)
	public Patient getPatient(@PathVariable("id") int id) {
		return patientRepo.findById(id).get();
	}
	
	@RequestMapping(value="/patients/{id}", method=RequestMethod.DELETE)
	public void deletetPatient(@PathVariable("id") int id) {
		Patient patient = patientRepo.findById(id).get();
		patientRepo.delete(patient);;
	}

	@RequestMapping(value = "/patients", method = RequestMethod.POST)
	public Patient savePatient(@RequestBody Patient patient) {
		return patientRepo.save(patient);
	}

	//it return the oldest report
	@RequestMapping(value = "/patients/analyze/{id}", method = RequestMethod.GET)
	public Patient analyze(@PathVariable("id") int id) {
		Patient patient = patientRepo.findById(id).get();
		List<ClinicalData> clinicalData = patient.getClinicalDataList();
		ArrayList<ClinicalData> duplicateClinicalData = new ArrayList<>(clinicalData);
		for (ClinicalData eachEntry : duplicateClinicalData) {
			if(filters.containsKey(eachEntry.getComponentName())) {
				clinicalData.remove(eachEntry);
				continue;
			}
			else {
				filters.put(eachEntry.getComponentName(), null);
			}
			if (eachEntry.getComponentName().equals("hw")) {
				String[] heightAndWeight = eachEntry.getComponentValue().split("/");
				if (heightAndWeight != null && heightAndWeight.length > 1) {
					float heightInMeters = Float.parseFloat(heightAndWeight[0]) * 0.4536F;
					float bmi = Float.parseFloat(heightAndWeight[1]) / (heightInMeters * heightInMeters);
					ClinicalData bmiData = new ClinicalData();
					bmiData.setComponentName("bmi");
					bmiData.setComponentValue(Float.toString(bmi));
					System.out.println(bmiData.toString());
					clinicalData.add(bmiData);
				}
			}
		}
		filters.clear();
		return patient;
	}
	
	//it return the latest report details
	@RequestMapping(value = "/patients/analyzes/{id}", method = RequestMethod.GET)
	public Patient analyzes(@PathVariable("id") int id) {
		Patient patient = patientRepo.findById(id).get();
		List<ClinicalData> clinicalData = patient.getClinicalDataList();
		ArrayList<ClinicalData> duplicateClinicalData = new ArrayList<>(clinicalData);
		for (ClinicalData eachEntry : duplicateClinicalData) {
			if(filters.containsKey(eachEntry.getComponentName())) {
				ClinicalData delete = filters.get(eachEntry.getComponentName());
				clinicalData.remove(delete);
				filters.put(eachEntry.getComponentName(), eachEntry);
			}
			else {
				filters.put(eachEntry.getComponentName(),eachEntry);
			}
			if (eachEntry.getComponentName().equals("hw")) {
				if(filters.get("bmi") != null) {
					clinicalData.remove(filters.get("bmi"));
				}
				if(filters.get("bmi") ==  null) {
					String[] heightAndWeight = eachEntry.getComponentValue().split("/");
					if (heightAndWeight != null && heightAndWeight.length > 1) {
						float heightInMeters = Float.parseFloat(heightAndWeight[0]) * 0.4536F;
						float bmi = Float.parseFloat(heightAndWeight[1]) / (heightInMeters * heightInMeters);
						ClinicalData bmiData = new ClinicalData();
						bmiData.setComponentName("bmi");
						bmiData.setComponentValue(Float.toString(bmi));
						filters.put("bmi",eachEntry);
						clinicalData.add(bmiData);
					}
				}
			}
		}
		filters.clear();
		return patient;
	}
}

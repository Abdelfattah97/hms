package com.hospital.management.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.management.model.entity.Patient;
import com.hospital.management.model.repository.PatientRepo;
@Service
public class PatientService implements ServiceInterface<Patient, Long>{

	@Autowired
	PatientRepo patientRepo;
	
	@Override
	public List<Patient> findAll() {
		
		return patientRepo.findAll();
	}

	@Override
	public Patient findById(Long id) {
		return patientRepo.findById(id).orElse(null);
	}

	@Override
	public Patient save(Patient patient) {
		return patientRepo.save(patient);
		
	}

	@Override
	public void deleteById(Long id) {
		patientRepo.deleteById(id);
	}

	@Override
	public void delete(Patient patient) {
		patientRepo.delete(patient);
	}

}

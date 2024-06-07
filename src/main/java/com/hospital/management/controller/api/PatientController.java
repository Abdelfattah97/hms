package com.hospital.management.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.management.model.entity.Patient;
import com.hospital.management.model.service.PatientService;

@RestController
@RequestMapping("/api/patient")
public class PatientController {
	@Autowired
	PatientService patientService;
	
	@GetMapping()
	public List<Patient> findAll() {
		
		return patientService.findAll();
	}

	@GetMapping("/{id}")
	public Patient findById(@PathVariable Long id) {
		return patientService.findById(id);
	}

	@PostMapping()
	public Patient save(@RequestBody Patient patient) {
		return patientService.save(patient);
		
	}

	@DeleteMapping("{id}")
	public void deleteById(@PathVariable Long id) {
		patientService.deleteById(id);
	}

	@DeleteMapping()
	public void delete(@RequestBody Patient patient) {
		patientService.delete(patient);
	}
}

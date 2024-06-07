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

import com.hospital.management.model.entity.Doctor;
import com.hospital.management.model.service.DoctorService;

@RestController
@RequestMapping("/api/doctor")
public class DoctorController {
	@Autowired
	DoctorService doctorService;
	
	@GetMapping()
	public List<Doctor> findAll() {
		
		return doctorService.findAll();
	}

	@GetMapping("/{id}")
	public Doctor findById(@PathVariable Long id) {
		return doctorService.findById(id);
	}

	@PostMapping()
	public Doctor save(@RequestBody Doctor doctor) {
		return doctorService.save(doctor);
		
	}

	@DeleteMapping("{id}")
	public void deleteById(@PathVariable Long id) {
		doctorService.deleteById(id);
	}

	@DeleteMapping()
	public void delete(@RequestBody Doctor doctor) {
		doctorService.delete(doctor);
	}
}

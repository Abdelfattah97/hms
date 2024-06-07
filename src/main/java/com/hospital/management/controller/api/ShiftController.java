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

import com.hospital.management.model.entity.Shift;
import com.hospital.management.model.service.ShiftService;

@RestController
@RequestMapping("/api/shift")
public class ShiftController {
	@Autowired
	ShiftService shiftService;
	
	@GetMapping()
	public List<Shift> findAll() {
		
		return shiftService.findAll();
	}

	@GetMapping("/{id}")
	public Shift findById(@PathVariable Long id) {
		return shiftService.findById(id);
	}
	@GetMapping("/doctor/{doctorId}")
	public List<Shift> findByDoctorId(@PathVariable Long doctorId ){
		
		return shiftService.findByDoctorId(doctorId);
		
	}
	

	@PostMapping()
	public Shift save(@RequestBody Shift shift) {
		return shiftService.save(shift);
		
	}

	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable Long id) {
		shiftService.deleteById(id);
	}

	@DeleteMapping()
	public void delete(@RequestBody Shift shift) {
		shiftService.delete(shift);
	}
}

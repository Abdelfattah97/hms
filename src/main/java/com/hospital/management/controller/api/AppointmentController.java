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

import com.hospital.management.model.entity.Appointment;
import com.hospital.management.model.service.AppointmentService;

@RestController
@RequestMapping("/api/appointment")
public class AppointmentController {
	@Autowired
	AppointmentService appointmentService;
	
	@GetMapping()
	public List<Appointment> findAll() {
		
		return appointmentService.findAll();
	}

	@GetMapping("/{id}")
	public Appointment findById(@PathVariable Long id) {
		return appointmentService.findById(id);
	}

	@PostMapping()
	public Appointment save(@RequestBody Appointment appointment) {
		return appointmentService.save(appointment);
		
	}

	@DeleteMapping("{id}")
	public void deleteById(@PathVariable Long id) {
		appointmentService.deleteById(id);
	}

	@DeleteMapping()
	public void delete(@RequestBody Appointment appointment) {
		appointmentService.delete(appointment);
	}
}

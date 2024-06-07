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

import com.hospital.management.model.entity.Insurance;
import com.hospital.management.model.service.InsuranceService;

@RestController
@RequestMapping("/api/insurance")
public class InsuranceController {
	@Autowired
	InsuranceService insuranceService;
	
	@GetMapping()
	public List<Insurance> findAll() {
		
		return insuranceService.findAll();
	}

	@GetMapping("/{id}")
	public Insurance findById(@PathVariable Long id) {
		return insuranceService.findById(id);
	}

	@PostMapping()
	public Insurance save(@RequestBody Insurance insurance) {
		return insuranceService.save(insurance);
		
	}

	@DeleteMapping("{id}")
	public void deleteById(@PathVariable Long id) {
		insuranceService.deleteById(id);
	}

	@DeleteMapping()
	public void delete(@RequestBody Insurance insurance) {
		insuranceService.delete(insurance);
	}
}

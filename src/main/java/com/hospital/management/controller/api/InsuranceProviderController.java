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

import com.hospital.management.model.entity.InsuranceProvider;
import com.hospital.management.model.service.InsuranceProviderService;

@RestController
@RequestMapping("/api/insurance-provider")
public class InsuranceProviderController {
	@Autowired
	InsuranceProviderService insuranceProviderService;
	
	@GetMapping()
	public List<InsuranceProvider> findAll() {
		
		return insuranceProviderService.findAll();
	}

	@GetMapping("/{id}")
	public InsuranceProvider findById(@PathVariable Long id) {
		return insuranceProviderService.findById(id);
	}

	@PostMapping()
	public InsuranceProvider save(@RequestBody InsuranceProvider insuranceProvider) {
		return insuranceProviderService.save(insuranceProvider);
		
	}

	@DeleteMapping("{id}")
	public void deleteById(@PathVariable Long id) {
		insuranceProviderService.deleteById(id);
	}

	@DeleteMapping()
	public void delete(@RequestBody InsuranceProvider insuranceProvider) {
		insuranceProviderService.delete(insuranceProvider);
	}
}

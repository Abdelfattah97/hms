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

import com.hospital.management.model.entity.Specialize;
import com.hospital.management.model.service.SpecializeService;

@RestController
@RequestMapping("/api/specialize")
public class SpecializeController {
	@Autowired
	SpecializeService specializeService;
	
	@GetMapping()
	public List<Specialize> findAll() {
		
		return specializeService.findAll();
	}

	@GetMapping("/{id}")
	public Specialize findById(@PathVariable Long id) {
		return specializeService.findById(id);
	}

	@PostMapping()
	public Specialize save(@RequestBody Specialize specialize) {
		return specializeService.save(specialize);
		
	}

	@DeleteMapping("{id}")
	public void deleteById(@PathVariable Long id) {
		specializeService.deleteById(id);
	}

	@DeleteMapping()
	public void delete(@RequestBody Specialize specialize) {
		specializeService.delete(specialize);
	}
}

package com.hospital.management.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.management.model.entity.Specialize;
import com.hospital.management.model.repository.SpecializeRepo;
@Service
public class SpecializeService implements ServiceInterface<Specialize, Long>{

	@Autowired
	SpecializeRepo specializeRepo;
	
	@Override
	public List<Specialize> findAll() {
		
		return specializeRepo.findAll();
	}

	@Override
	public Specialize findById(Long id) {
		return specializeRepo.findById(id).orElse(null);
	}

	@Override
	public Specialize save(Specialize specialize) {
		return specializeRepo.save(specialize);
		
	}

	@Override
	public void deleteById(Long id) {
		specializeRepo.deleteById(id);
	}

	@Override
	public void delete(Specialize specialize) {
		specializeRepo.delete(specialize);
	}

}

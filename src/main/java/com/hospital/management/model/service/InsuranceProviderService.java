package com.hospital.management.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.management.model.entity.InsuranceProvider;
import com.hospital.management.model.repository.InsuranceProviderRepo;
@Service
public class InsuranceProviderService implements ServiceInterface<InsuranceProvider, Long>{

	@Autowired
	InsuranceProviderRepo insuranceProviderRepo;
	
	@Override
	public List<InsuranceProvider> findAll() {
		
		return insuranceProviderRepo.findAll();
	}

	@Override
	public InsuranceProvider findById(Long id) {
		return insuranceProviderRepo.findById(id).orElse(null);
	}

	@Override
	public InsuranceProvider save(InsuranceProvider insuranceProvider) {
		return insuranceProviderRepo.save(insuranceProvider);
		
	}

	@Override
	public void deleteById(Long id) {
		insuranceProviderRepo.deleteById(id);
	}

	@Override
	public void delete(InsuranceProvider insuranceProvider) {
		insuranceProviderRepo.delete(insuranceProvider);
	}

}

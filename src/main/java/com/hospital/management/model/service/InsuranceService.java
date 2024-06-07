package com.hospital.management.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.management.model.entity.Insurance;
import com.hospital.management.model.repository.InsuranceRepo;
@Service
public class InsuranceService implements ServiceInterface<Insurance, Long>{

	@Autowired
	InsuranceRepo insuranceRepo;
	
	@Override
	public List<Insurance> findAll() {
		
		return insuranceRepo.findAll();
	}

	@Override
	public Insurance findById(Long id) {
		return insuranceRepo.findById(id).orElse(null);
	}

	@Override
	public Insurance save(Insurance insurance) {
		return insuranceRepo.save(insurance);
		
	}

	@Override
	public void deleteById(Long id) {
		insuranceRepo.deleteById(id);
	}

	@Override
	public void delete(Insurance insurance) {
		insuranceRepo.delete(insurance);
	}

}

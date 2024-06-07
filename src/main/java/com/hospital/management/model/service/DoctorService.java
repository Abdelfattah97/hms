package com.hospital.management.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.management.model.entity.Doctor;
import com.hospital.management.model.repository.DoctorRepo;
@Service
public class DoctorService implements ServiceInterface<Doctor, Long>{

	@Autowired
	DoctorRepo doctorRepo;
	
	@Override
	public List<Doctor> findAll() {
		
		return doctorRepo.findAll();
	}

	@Override
	public Doctor findById(Long id) {
		return doctorRepo.findById(id).orElse(null);
	}

	@Override
	public Doctor save(Doctor doctor) {
		return doctorRepo.save(doctor);
		
	}

	@Override
	public void deleteById(Long id) {
		doctorRepo.deleteById(id);
	}

	@Override
	public void delete(Doctor doctor) {
		doctorRepo.delete(doctor);
	}

}

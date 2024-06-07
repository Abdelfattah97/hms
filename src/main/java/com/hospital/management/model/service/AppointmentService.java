package com.hospital.management.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.management.model.entity.Appointment;
import com.hospital.management.model.repository.AppointmentRepo;
@Service
public class AppointmentService implements ServiceInterface<Appointment, Long> {

	@Autowired
	AppointmentRepo appointmentRepo;

	@Override
	public List<Appointment> findAll() {

		return appointmentRepo.findAll();
	}

	@Override
	public Appointment findById(Long id) {
		return appointmentRepo.findById(id).orElse(null);
	}

	@Override
	public Appointment save(Appointment appointment) {
		return appointmentRepo.save(appointment);

	}

	@Override
	public void deleteById(Long id) {
		appointmentRepo.deleteById(id);
	}

	@Override
	public void delete(Appointment appointment) {
		appointmentRepo.delete(appointment);
	}

}

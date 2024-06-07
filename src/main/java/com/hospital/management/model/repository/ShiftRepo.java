package com.hospital.management.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospital.management.model.entity.Appointment;
import com.hospital.management.model.entity.Shift;

import java.time.DayOfWeek;
import java.util.List;
import java.util.Optional;


public interface ShiftRepo extends JpaRepository<Shift, Long> {

	List<Shift> findByDoctor_DoctorId(Long doctorId);
	List<Shift> findByDoctor_DoctorIdAndDayOfWeek(Long doctorId,DayOfWeek dayOfWeek);
	
}

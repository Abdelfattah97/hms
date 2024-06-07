package com.hospital.management.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospital.management.model.entity.Appointment;

public interface AppointmentRepo extends JpaRepository<Appointment, Long> {

}

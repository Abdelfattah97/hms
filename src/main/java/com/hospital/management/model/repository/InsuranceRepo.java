package com.hospital.management.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospital.management.model.entity.Appointment;
import com.hospital.management.model.entity.Insurance;

public interface InsuranceRepo extends JpaRepository<Insurance, Long> {

}

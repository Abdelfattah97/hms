package com.hospital.management.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospital.management.model.entity.Patient;

public interface PatientRepo extends JpaRepository<Patient, Long> {

}

package com.hospital.management.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospital.management.model.entity.Doctor;

public interface DoctorRepo extends JpaRepository<Doctor, Long> {

}

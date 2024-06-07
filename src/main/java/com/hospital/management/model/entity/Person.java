package com.hospital.management.model.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

@MappedSuperclass
@Data
public abstract class Person {

	
	@Column(length = 15,nullable = false)
	private String firstName;
	
	@Column(length = 15)
	private String middleName;

	@Column(length = 15 , nullable = false)
	private String surName;
	
	private LocalDate birthDate;
	
	
	
}

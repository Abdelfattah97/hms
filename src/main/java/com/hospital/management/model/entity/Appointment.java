package com.hospital.management.model.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.ConstraintMode;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
@JsonInclude(content = Include.NON_NULL)
public class Appointment {

	@Id
	@GeneratedValue
	private Long appointement_id;
	
	@ManyToOne(fetch = FetchType.EAGER ,cascade = {CascadeType.MERGE,CascadeType.DETACH})
	@JoinColumn(name = "doctor_id",nullable = false)
	@JsonIgnoreProperties(value = "appointments")
	private Doctor doctor;
	
	@ManyToOne(fetch = FetchType.EAGER ,cascade = {CascadeType.MERGE,CascadeType.DETACH})
	@JoinColumn(name = "patient_id",nullable = false)
	@JsonIgnoreProperties(value = "appointments")
	private Patient patient;
	
	@Column(nullable = false)
	private LocalDate appointDate;
	private LocalTime appointTime;
	@Column()
	private Boolean Paid=false;
	
	
	
	
	
	
}

package com.hospital.management.model.entity;

import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Patient extends Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long patientId ;
	
	
	@OneToMany(fetch = FetchType.LAZY , mappedBy = "patient",cascade = {CascadeType.MERGE,CascadeType.DETACH})
	@JsonIgnoreProperties(value = "patient")
	private Collection<Appointment> appointments;
	
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "patient",cascade = {CascadeType.MERGE,CascadeType.DETACH})
	@JsonIgnoreProperties(value="patient")
	private Collection <Insurance> insurances;
	
	
	
	
	
}

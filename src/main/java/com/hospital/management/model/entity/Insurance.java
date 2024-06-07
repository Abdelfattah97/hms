package com.hospital.management.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
public class Insurance {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long insurance_id;
	
	@Column(length = 30,nullable = false)
	String insuranceNum;
	
	@ManyToOne(fetch =FetchType.EAGER ,cascade = {CascadeType.MERGE,CascadeType.DETACH})
	@JoinColumn(name="provider_id",nullable = false)
	@JsonIgnoreProperties(value = "insurances")
	InsuranceProvider insuranceProvider;
	
	@ManyToOne(fetch = FetchType.EAGER,cascade = {CascadeType.MERGE,CascadeType.DETACH})
	@JoinColumn(name="patient_id",nullable = false)
	@JsonIgnoreProperties(value = "insurances")
	Patient patient;
	
}

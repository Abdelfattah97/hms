package com.hospital.management.model.entity;

import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
public class InsuranceProvider {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long ProviderId ;
	
	@Column(nullable = false)
	String name;
	
	@OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.DETACH,mappedBy = "insuranceProvider")
	@JsonIgnoreProperties(value="insuranceProvider")
	Collection<Insurance>  insurances;
	
	
	
	
}

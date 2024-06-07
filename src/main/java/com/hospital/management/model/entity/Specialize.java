package com.hospital.management.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Specialize {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long specializeId;
	
	@Column(nullable = false)
	String name;
	
	String description;
	
	
}

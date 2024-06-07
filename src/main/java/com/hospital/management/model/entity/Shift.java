package com.hospital.management.model.entity;

import java.time.DayOfWeek;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table()
@Data
public class Shift {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long shift_id;
	
	private DayOfWeek dayOfWeek ;
	
	@Column()
	private LocalTime shiftStart;
	private LocalTime shiftEnd;
	
	@ManyToOne(cascade = {CascadeType.MERGE,CascadeType.DETACH})
	@JoinColumn(name="doctor_id")
	@JsonIgnoreProperties({"shifts","appointments","birthDate"})
	private Doctor doctor;
	
	
	
	
	
	
	
	

}

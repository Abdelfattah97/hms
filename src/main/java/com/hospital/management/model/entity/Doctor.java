package com.hospital.management.model.entity;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Doctor extends Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long doctorId;

	@OneToMany(fetch = FetchType.LAZY , mappedBy = "doctor")
	@JsonIgnoreProperties(value = "doctor")
	private Collection<Appointment> appointments;
	
	@ManyToOne(fetch =FetchType.EAGER,  cascade = {CascadeType.MERGE,CascadeType.DETACH})
	@JoinColumn(name="specialize_id")
	private Specialize specialize;
	
	@OneToMany(mappedBy = "doctor",cascade = {CascadeType.ALL})
	private List<Shift> shifts ;
	
	public String getFullName(){
		String firstName = this.getFirstName();
		String middleName = this.getMiddleName();
		String surName = this.getSurName();
		
		StringBuilder sb = new StringBuilder();
		if(firstName!=null) {
			sb.append(firstName);
			if(middleName !=null) {
				sb.append(" "+middleName);
			}
			if(surName!=null) {
				sb.append(" "+surName);
			}
		}
		return sb.toString();
		
	}
	
	
	
}

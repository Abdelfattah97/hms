package com.hospital.management.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hospital.management.model.entity.Patient;


public interface ServiceInterface<E,ID> {

	
	public List<E> findAll();
	
	public E findById(ID id);
	
	public E save(E entity);
	
	public void deleteById(ID id);
	
	public void delete(E entity);
	
	
}

package com.hospital.management.model.repository.converters;

import java.time.LocalDate;
import java.util.Optional;
import java.sql.Date;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class LocalDateConverter implements AttributeConverter<LocalDate, Date> {

	@Override
	public java.sql.Date convertToDatabaseColumn(LocalDate attribute) {
		return Optional.ofNullable(attribute)
		.map(Date::valueOf)
		.orElse(null);
	}

	@Override
	public LocalDate convertToEntityAttribute(Date dbData) {
		// TODO Auto-generated method stub
		return Optional.ofNullable(dbData)
				.map(Date::toLocalDate)
				.orElse(null);
	}

	
	
	
	
}

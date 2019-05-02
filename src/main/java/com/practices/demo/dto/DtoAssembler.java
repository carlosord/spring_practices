package com.practices.demo.dto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;

import com.practices.demo.model.Car;
import com.practices.demo.model.Person;

public class DtoAssembler {
	private static SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

	public static Person toEntity(PersonDto dto) {
		Person entity = new Person();
		entity.setId(dto.getId());
		entity.setDni(dto.getDni());
		entity.setName(dto.getName());
		entity.setLastname(dto.getLastname());
		try {
			entity.setBirthday(format.parse(dto.getBirthday()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		entity.setGender(dto.getGender());
		entity.setHascar(dto.getHascar());
		return entity;
	}

	public static PersonDto fromEntity(Person entity) {
		PersonDto dto = new PersonDto();
		dto.setId(entity.getId());
		dto.setDni(entity.getDni());
		dto.setName(entity.getName());
		dto.setLastname(entity.getLastname());
		if(entity.getBirthday() != null) {
			dto.setBirthday(format.format(entity.getBirthday()));
			dto.setAge((int) ChronoUnit.YEARS.between(Instant.ofEpochMilli(entity.getBirthday().getTime()).atZone(ZoneId.systemDefault()).toLocalDate() , LocalDate.now()));
		}
		dto.setGender(entity.getGender());
		dto.setHascar(entity.getHascar());
		return dto;
	}

	public static Car toEntity(CarDto dto) {
		Car entity = new Car();
		entity.setId(dto.getId());
		entity.setLicense(dto.getLicense());
		entity.setColour(dto.getColour());
		entity.setNumberofcardoors(dto.getNumberofcardoors());
		return entity;
	}

	public static CarDto fromEntity(Car entity) {
		CarDto dto = new CarDto();
		dto.setId(entity.getId());
		dto.setLicense(entity.getLicense());
		dto.setColour(entity.getColour());
		dto.setNumberofcardoors(entity.getNumberofcardoors());
		return dto;
	}
}

package com.practices.demo.dto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;

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
}

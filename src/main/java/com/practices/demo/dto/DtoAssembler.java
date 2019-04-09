package com.practices.demo.dto;

import com.practices.demo.model.Person;

public class DtoAssembler {

	public static Person toPerson(PersonDto dto) {
		Person entity = new Person();
		entity.setId(dto.getId());
		entity.setDni(dto.getDni());
		entity.setName(dto.getName());
		entity.setLastname(dto.getLastname());
		entity.setAge(dto.getAge());
		entity.setGender(dto.getGender());
		entity.setHascar(dto.getHascar());
		return entity;
	}

	public static PersonDto fromPerson(Person entity) {
		PersonDto dto = new PersonDto();
		dto.setId(entity.getId());
		dto.setDni(entity.getDni());
		dto.setName(entity.getName());
		dto.setLastname(entity.getLastname());
		dto.setAge(entity.getAge());
		dto.setGender(entity.getGender());
		dto.setHascar(entity.getHascar());
		return dto;
	}
}

package com.practices.demo.utils;

import java.util.List;

import com.practices.demo.dto.PersonDto;
import com.practices.demo.model.Persona;

public class PersonUtils{


	public static Persona _toconvertPersonaDTO(PersonDto pdt) {
		Persona p = new Persona();
		p.setId(pdt.getId());
		p.setDni(pdt.getDni());
		p.setName(pdt.getName());
		p.setLastname(pdt.getLastname());
		p.setAge(pdt.getAge());
		p.setFecha(pdt.getFecha());
		p.setGender(pdt.getGender());
		p.setHascar(pdt.isHascar());
		return p;
	}

	public static PersonDto _toConvertPersonaEntity(Persona pe) {
		PersonDto pd = new PersonDto();
		pd.setId(pe.getId());
		pd.setDni(pe.getDni());
		pd.setName(pe.getName());
		pd.setLastname(pe.getLastname());
		pd.setFullname(pe.getFullname());
		pd.setAge(pe.getAge());
		pd.setFecha(pe.getFecha());
		pd.setGender(pe.getGender());
		pd.setHascar(pe.isHascar());
		return pd;
	}


}

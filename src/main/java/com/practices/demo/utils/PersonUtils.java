package com.practices.demo.utils;


import java.text.SimpleDateFormat;
import java.text.ParseException;

import com.practices.demo.dto.PersonaDTO;
import com.practices.demo.model.Persona;

public class PersonUtils {

	static SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

	public static Persona _toConvertPersonDTO(PersonaDTO dto) {

		Persona p = new Persona();

		p.setId(dto.getId());
		p.setDni(dto.getDni());
		p.setName(dto.getName());
		p.setLastname(dto.getLastname());
		p.setAge(dto.getAge());
		p.setGender(dto.getGender());
		p.setHascar(dto.isHascar());

		try {
			p.setFechanac(format.parse(dto.getFechanac()));
		} catch (ParseException e) {
			p.setFechanac(null);
		}

		return p;
	}

	public static PersonaDTO _toConvertPersonEntity(Persona pe) {

		PersonaDTO pd= new PersonaDTO();
		pd.setId(pe.getId());
		pd.setDni(pe.getDni());
		pd.setName(pe.getName());
		pd.setLastname(pe.getLastname());
		pd.setAge(pe.getAge());
		pd.setGender(pe.getGender());
		pd.setHascar(pe.isHascar());
		pd.setFullname(pe.getFullname());
		//pd.setFechanac(pe.getFechanac());
		pd.setFechanac(format.format(pe.getFechanac()));

		//this.setFechanac(format.format(pe.getFechanac()));

		return pd;
	}

}

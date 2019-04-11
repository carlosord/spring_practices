package com.practices.demo.utils;


import com.practices.demo.dto.PersonaDTO;
import com.practices.demo.model.Persona;

public class PersonUtils {

	public static Persona _toConvertPersonDTO(PersonaDTO dto) {
		Persona p = new Persona();
		p.setId(dto.getId());
		p.setDni(dto.getDni());
		p.setName(dto.getName());
		p.setLastname(dto.getLastname());
		p.setAge(dto.getAge());
		p.setGender(dto.getGender());
		p.setHascar(dto.isHascar());
		p.setFechanac(dto.getFechanac());

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
		pd.setFechanac(pe.getFechanac());

		return pd;
	}

}

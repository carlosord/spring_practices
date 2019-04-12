package com.practices.demo.utils;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.text.ParseException;

import com.practices.demo.dto.PersonaDTO;
import com.practices.demo.model.Persona;

/**
 * Esta clase es una clase de utilidades para transformar
 * @author Jairo.Rodriguez
 *
 */
public class PersonUtils {

	/**
	 * Este campo es el del formato de la fecha.
	 */
	static SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");


	/**
	 * Este metodo me transforma una objeto de tipo PersonaDTO en otro objeto de tipo {@code Persona}
	 *
	 * @param dto
	 * 			es el objeto de tipo {@code PersonaDTO}  que voy a convertir
	 * @return devuelto un objeto de tipo {@code Persona} convertida del objeto de tipo PersonaDTO que recibo.
	 */
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

	/**
	 * Este metodo me transforma una objeto de tipo Persona en otro objeto de tipo {@code PersonaDTO}
	 *
	 * @param pe
	 * 			es el objeto de tipo {@code Persona}  que voy a convertir
	 * @return devuelto un objeto de tipo {@code PersonaDTO} convertida del objeto de tipo Persona que recibo.
	 */
	public static PersonaDTO _toConvertPersonEntity(Persona pe) {

		PersonaDTO pd = new PersonaDTO();


		pd.setId(pe.getId());
		pd.setDni(pe.getDni());
		pd.setName(pe.getName());
		pd.setLastname(pe.getLastname());
		pd.setAge(calculateYear(pe));
		pd.setGender(pe.getGender());
		pd.setHascar(pe.isHascar());
		pd.setFullname(pe.getFullname());
		// pd.setFechanac(pe.getFechanac());
		pd.setFechanac(format.format(pe.getFechanac()));

		// this.setFechanac(format.format(pe.getFechanac()));

		return pd;
	}

	public static int calculateYear(Persona pe) {

//		PersonaDTO pdt = new PersonaDTO();
//	DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//		LocalDate fechaNac = LocalDate.parse(pdt.getFechanac(), fmt);
//		LocalDate ahora = LocalDate.now();
//		Period periodo = Period.between(fechaNac, ahora);
		LocalDate today = LocalDate.now();
		LocalDate bornDate = pe.getFechanac().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		Period period = Period.between(bornDate, today);

		return period.getYears();
	}

}

package com.practices.demo.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import com.practices.demo.dto.PersonDto;
import com.practices.demo.model.Persona;

/**
 * Clase que contiene los métodos que se encargan de pasar de {@code Persona} a {@code PersonDto} y viceversa.
 * @author Daniel.perez
 *
 */
public class PersonUtils{

	/**
	 * Este método esatico se encarga de convertir de {@code Persona} a {@code PersonDto}
	 * @param pdt es la llamada al objeto {@code PersonDto}
	 * @return Retorna un objeto {@code Persona}
	 */
	public static Persona _toconvertPersonaDTO(PersonDto pdt) {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Persona p = new Persona();
		p.setId(pdt.getId());
		p.setDni(pdt.getDni());
		p.setName(pdt.getName());
		p.setLastname(pdt.getLastname());
		try {
			p.setFecha(format.parse(pdt.getFecha()));
		} catch (ParseException e) {
			p.setFecha(null);
		}
		p.setGender(pdt.getGender());
		p.setHascar(pdt.isHascar());
		return p;
	}

	/**
	 * Este método estatico se encarga de convertir de {@code PersonDto} a {@code Persona}
	 * @param pe es la llamada al objeto {@code Persona}
	 * @return Retorna un objeto {@code Persona}
	 */
	public static PersonDto _toConvertPersonaEntity(Persona pe) {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		PersonDto pd = new PersonDto();

		pd.setId(pe.getId());
		pd.setDni(pe.getDni());
		pd.setName(pe.getName());
		pd.setLastname(pe.getLastname());
		pd.setFullname(pe.getFullname());
		pd.setAge(calculateYear(pe));
		pd.setFecha(format.format(pe.getFecha()));
		pd.setGender(pe.getGender());
		pd.setHascar(pe.isHascar());
		return pd;
	}

	/**
	 * Este método estatico se encarga de calcular la edad a partir de la fecha.
	 * @param pe es la llamada al objeto {@code Persona}
	 * @return Retorna un integer en este caso la edad.
	 */
	private static int calculateYear(Persona pe) {

		LocalDate ahora = LocalDate.now();
		LocalDate fechaNac = pe.getFecha().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

		Period periodo = Period.between(fechaNac, ahora);

		return periodo.getYears();

	}



}

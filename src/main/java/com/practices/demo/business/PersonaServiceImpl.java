package com.practices.demo.business;

import java.util.List;

import org.springframework.validation.BindingResult;

import com.practices.demo.dto.PersonDto;
import com.practices.demo.model.Persona;
import com.practices.demo.utils.PersonUtils;

/**
 *		Esta clase de tipo interface es la coleccion de métodos y propiedades constantes que se implementan en la clase {@code PersonServices}
 *
 * @author Daniel.perez
 *
 *
 */

public interface PersonaServiceImpl {

	public PersonDto create(PersonDto p) throws Exception;
	public PersonDto findById(Long id);
	public List<PersonDto> findAll();
	public void delete(Long id);
	public PersonDto updatePerson(PersonDto updatePerson);
	public PersonDto findPersonByDni(String dni);
}

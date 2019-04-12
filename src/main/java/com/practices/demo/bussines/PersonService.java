package com.practices.demo.bussines;

import java.util.List;

import org.springframework.validation.BindingResult;

import com.practices.demo.dto.PersonaDTO;

/**
 * Esta clase de tipo interface recoge la collecioon de metodos y propiedades constantes que se implementan en la clase ServiceIpl
 * @author Jairo.Rodriguez
 *
 */

public interface PersonService {

	public PersonaDTO registerUser(PersonaDTO p) throws Exception;

	public PersonaDTO edituser(String id);

	public PersonaDTO updatePerson(PersonaDTO p);

	public List<PersonaDTO> findAll();

	public void deleteUser(long id);

}

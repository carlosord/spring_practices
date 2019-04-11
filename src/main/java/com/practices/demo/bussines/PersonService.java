package com.practices.demo.bussines;

import java.util.List;

import org.springframework.validation.BindingResult;

import com.practices.demo.dto.PersonaDTO;

public interface PersonService {

	public PersonaDTO registerUser(PersonaDTO p) throws Exception;

	public PersonaDTO edituser(String id);

	public PersonaDTO updatePerson(PersonaDTO p);

	public List<PersonaDTO> findAll();

	public void deleteUser(long id);

}

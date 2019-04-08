package com.practices.demo.business;

import java.util.List;

import org.springframework.validation.BindingResult;

import com.practices.demo.model.Persona;

public interface PersonaServiceImpl {

	public Persona create(Persona p,BindingResult bindingResult);
	public Persona findById(Long id);
	public List<Persona> findAll();
	public void delete(Long id);
	public Persona updatePerson(Persona updatePerson);
}

package com.practices.demo.bussines;

import java.util.List;

import org.springframework.validation.BindingResult;

import com.practices.demo.model.Persona;

public interface PersonService {

	public Persona registerUser(Persona p, BindingResult bindingResult);
	public Persona edituser(String id);
	public Persona updatePerson(Persona p);
	public List<Persona> findAll();
	public void deleteUser(long id);

}

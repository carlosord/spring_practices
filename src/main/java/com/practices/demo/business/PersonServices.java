package com.practices.demo.business;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.practices.demo.model.Persona;
import com.practices.demo.persistence.PersonaRepository;
import com.practices.demo.validations.ValidacionDni;

@Component
public class PersonServices implements PersonaServiceImpl{

	@Autowired
	private PersonaRepository repo;

	@Autowired
	private ValidacionDni validator;

	public List<Persona> findAll() {
		 return repo.findAll();
	}

	public Persona create(Persona createPerson, BindingResult bindingResult) {

		validator.validate(createPerson, bindingResult);

		Persona p = repo.save(createPerson);

		return p;
	}

	public Persona findById( Long id) {
		Persona p = repo.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
		return p;
	}

	public Persona updatePerson(Persona updatePerson) {
		Persona p =repo.save(updatePerson);
		return p;
	}

	public void delete(Long id) {
		repo.deleteById(id);
	}



}
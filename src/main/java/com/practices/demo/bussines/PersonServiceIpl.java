package com.practices.demo.bussines;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.practices.demo.model.Persona;
import com.practices.demo.persistence.PersonaRepository;
import com.practices.demo.validations.ValidateDni;

@Component
public class PersonServiceIpl implements PersonService {

	@Autowired
	private PersonaRepository repo;

	@Autowired
	ValidateDni validator;

	public List<Persona> findAll() {

		return  repo.findAll();

	}

	public Persona registerUser(Persona createperson, BindingResult bindingResult) {

		validator.validate(createperson, bindingResult);

		Persona p=repo.save(createperson);

		return p;

	}

	public Persona edituser(String id) {

		Persona p = repo.findById(Long.valueOf(id))
				.orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));

		return p;

	}

	public Persona updatePerson(Persona updateperson) {

		Persona p=repo.save(updateperson);
		return p;

	}

	public void deleteUser(long id) {

		repo.deleteById(id);

	}


}

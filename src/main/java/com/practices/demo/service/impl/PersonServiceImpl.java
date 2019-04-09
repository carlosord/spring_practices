package com.practices.demo.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.practices.demo.dto.DtoAssembler;
import com.practices.demo.dto.PersonDto;
import com.practices.demo.model.Person;
import com.practices.demo.repositories.PersonRepository;
import com.practices.demo.service.PersonService;

/**
 * The Class PersonServiceImpl.
 */
@Service
public class PersonServiceImpl implements PersonService{
		
	/** The person repository. */
	@Autowired
	private PersonRepository personRepository;
	
	/**
	 * Find person by Id
	 */
	public PersonDto findPersonById(Long id) {
		Person p = personRepository.findById(id).orElseThrow(NoSuchElementException::new);
		return DtoAssembler.fromPerson(p);
	}

	/**
	 * Find all people
	 */
	public List<PersonDto> findAll() {
		List<Person> list = personRepository.findAll();
		return list.stream()
				.map(p -> DtoAssembler.fromPerson(p))
				.collect(Collectors.toList());
	}

	/**
	 * Find Person by DNI
	 */
	public PersonDto findPersonByDni(String dni) {
		Person p = personRepository.findByDni(dni);
		return DtoAssembler.fromPerson(p);
	}
	
	/**
	 * Adds the new person.
	 *
	 * @param model the model
	 * @param person the person
	 * @return the string
	 */
	public void addNewPerson(PersonDto person) {
		
		// Add new person to db
		personRepository.save(DtoAssembler.toPerson(person));
	}
	
	/**
	 * Update person.
	 *
	 * @param model the model
	 * @param person the person
	 * @return the string
	 */
	public void updatePerson(PersonDto person) {
		
		// Add new person to db
		personRepository.save(DtoAssembler.toPerson(person));
	}
	
	/**
	 * Delete person form.
	 *
	 * @param id the id
	 * @param model the model
	 * @return the string
	 */
	public void deletePersonForm(@PathVariable("id") Long id) {

		// Delete the person
		personRepository.deleteById(id);
	}
		
}

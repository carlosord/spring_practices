package com.practices.demo.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practices.demo.dto.DtoAssembler;
import com.practices.demo.dto.PersonDto;
import com.practices.demo.repositories.PersonRepository;
import com.practices.demo.service.PersonService;

/**
 * The Class PersonServiceImpl.
 */
@Service
public class PersonServiceImpl implements PersonService {

	/** The person repository. */
	@Autowired
	private PersonRepository personRepository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.practices.demo.service.PersonService#findPersonById(java.lang.Long)
	 */
	public PersonDto findPersonById(Long id) {
		return DtoAssembler.fromEntity(
				personRepository.findById(id).orElseThrow(NoSuchElementException::new));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.practices.demo.service.PersonService#findAll()
	 */
	public List<PersonDto> findAll() {
		return personRepository.findAll().stream().map(
				DtoAssembler::fromEntity).collect(Collectors.toList());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.practices.demo.service.PersonService#findPersonByDni(java.lang.String)
	 */
	public PersonDto findPersonByDni(String dni) {

		return DtoAssembler.fromEntity(personRepository.findByDni(dni));

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.practices.demo.service.PersonService#addNewPerson(com.practices.demo.dto.
	 * PersonDto)
	 */
	public PersonDto addNewPerson(PersonDto person) {

		// Add new person to db
		return DtoAssembler.fromEntity(
				personRepository.save(DtoAssembler.toEntity(person)));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.practices.demo.service.PersonService#updatePerson(com.practices.demo.dto.
	 * PersonDto)
	 */
	public PersonDto updatePerson(PersonDto person) {

		// Update person
		return DtoAssembler.fromEntity(
				personRepository.save(DtoAssembler.toEntity(person)));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.practices.demo.service.PersonService#deletePersonForm(java.lang.Long)
	 */
	public void deletePersonForm(Long id) {

		// Delete the person
		personRepository.deleteById(id);
	}

}

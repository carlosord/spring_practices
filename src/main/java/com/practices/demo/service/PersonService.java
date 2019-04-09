package com.practices.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.practices.demo.dto.PersonDto;

/**
 * The Class PersonService.
 */
@Service
public interface PersonService {
		
	/**
	 * Find person by id.
	 *
	 * @param id the id
	 * @return the person dto
	 */
	public PersonDto findPersonById(Long id);

	/**
	 * Find all.
	 *
	 * @return the list
	 */
	public List<PersonDto> findAll() ;

	/**
	 * Find person by dni.
	 *
	 * @param dni the dni
	 * @return the person dto
	 */
	public PersonDto findPersonByDni(String dni);
	
	/**
	 * Adds the new person.
	 *
	 * @param person the person
	 * @return the person dto
	 */
	public PersonDto addNewPerson(PersonDto person);
	
	/**
	 * Update person.
	 *
	 * @param person the person
	 * @return the person dto
	 */
	public PersonDto updatePerson(PersonDto person);
	
	/**
	 * Delete person form.
	 *
	 * @param id the id
	 */
	public void deletePersonForm(Long id);		
}

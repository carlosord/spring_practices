package com.practices.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.practices.demo.dto.PersonDto;

/**
 * The Class PersonService.
 */
@Service
public interface PersonService {
		
	public PersonDto findPersonById(Long id);

	public List<PersonDto> findAll() ;

	public PersonDto findPersonByDni(String dni);
	
	public void addNewPerson(PersonDto person);
	
	public void updatePerson(PersonDto person);
	
	public void deletePersonForm(@PathVariable("id") Long id);		
}

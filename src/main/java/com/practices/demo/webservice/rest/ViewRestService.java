package com.practices.demo.webservice.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.practices.demo.presentation.front.Url;
import com.practices.demo.service.PersonService;

/**
 * The Class ViewRestService.
 */
@RestController
public class ViewRestService {

	/** The person service. */
	@Autowired
	private PersonService personService;

	/**
	 * Show all person.
	 *
	 * @return the response entity
	 */
	@GetMapping(Url.SHOW_ALL_PERSON)
	public ResponseEntity<Object> showAllPerson() {
		return new ResponseEntity<>(personService.findAll(), HttpStatus.OK);
	}

	/**
	 * Delete person.
	 *
	 * @param id the id
	 */
	@DeleteMapping(Url.DELETE_PERSON + "/{id}")
	public void deletePerson(@PathVariable("id") Long id) {
		personService.deletePersonForm(id);
	}
}

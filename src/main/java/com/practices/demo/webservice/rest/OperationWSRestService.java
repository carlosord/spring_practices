package com.practices.demo.webservice.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.practices.demo.dto.PersonDto;
import com.practices.demo.presentation.front.Url;
import com.practices.demo.presentation.validation.PersonValidator;
import com.practices.demo.service.PersonService;

/**
 * The Class OperationWSRestService.
 */
@RestController
public class OperationWSRestService {

	/** The person service. */
	@Autowired
	private PersonService personService;

	/** The person validator. */
	@Autowired
	private PersonValidator personValidator;

	/**
	 * Find person by dni.
	 *
	 * @param dni the dni
	 * @return the response entity
	 */
	@GetMapping(Url.FIND_PERSON_REST_URL + "/{dni}")
	public ResponseEntity<PersonDto> findPersonByDni(@PathVariable("dni") String dni) {

		if (!personValidator.dniIsValid(dni)) {
			return ResponseEntity.notFound().build();
		}

		if (personService.findPersonByDni(dni) == null) {
			return ResponseEntity.notFound().build();
		}

		PersonDto show = personService.findPersonByDni(dni);

		return new ResponseEntity<>(show, HttpStatus.OK);
	}

	/**
	 * Update person.
	 *
	 * @param person the person
	 * @param id the id
	 * @return the response entity
	 */
	@PutMapping(Url.UPDATE_PERSON_REST_URL + "/{dni}")
	public ResponseEntity<PersonDto> updatePerson(@RequestBody PersonDto person, @PathVariable("dni") String dni) {

		PersonDto dto = personService.findPersonByDni(dni);

		dto.setDni(dni);
		PersonDto updated = personService.updatePerson(person);

		return new ResponseEntity<>(updated, HttpStatus.OK);

	}

}

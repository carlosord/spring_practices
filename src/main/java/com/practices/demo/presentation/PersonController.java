package com.practices.demo.presentation;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.practices.demo.model.Person;
import com.practices.demo.presentation.front.Url;
import com.practices.demo.presentation.front.View;
import com.practices.demo.repositories.PersonRepository;

/**
 * The Class PersonController.
 */
@Controller
public class PersonController {
		
	/** The person repository. */
	@Autowired
	private PersonRepository personRepository;
	
	/**
	 * Show all.
	 *
	 * @param model the model
	 * @return the string
	 */
	@GetMapping(Url.HOME_URL)
	public String showAll(ModelMap model) {
		
		// Add all people to model
		model.addAttribute("people", personRepository.findAll());
		
		// Return home view
		return View.HOME_VIEW;
		
	}
	
	/**
	 * Show new person form.
	 *
	 * @param model the model
	 * @return the string
	 */
	@GetMapping(Url.NEW_PERSON_URL)
	public String showNewPersonForm(ModelMap model) {
		
		// Add new person to model
		model.addAttribute("person", new Person());
		
		// Return new person view
		return View.NEW_PERSON_VIEW;
		
	}

	/**
	 * Adds the new person.
	 *
	 * @param model the model
	 * @param person the person
	 * @return the string
	 */
	@PostMapping(Url.NEW_PERSON_URL)
	public String addNewPerson(ModelMap model, Person person) {
		
		// Add new person to db
		personRepository.save(person);
		
		// Return new person view
		return View.redirect(View.HOME_VIEW);
		
	}
	
	/**
	 * Show new person form.
	 *
	 * @param id the id
	 * @param model the model
	 * @return the string
	 */
	@GetMapping(Url.EDIT_PERSON_URL + "/{id}")
	public String showEditPersonForm(@PathVariable("id") Long id, ModelMap model) {
		
		// Get the person
		Person person = personRepository.findById(id).orElseThrow(NoSuchElementException::new);
		
		// Add new person to model
		model.addAttribute("person", person);
		
		// Return new person view
		return View.EDIT_PERSON_VIEW;
		
	}

	/**
	 * Update person.
	 *
	 * @param model the model
	 * @param person the person
	 * @return the string
	 */
	@PostMapping(Url.EDIT_PERSON_URL)
	public String updatePerson(ModelMap model, Person person) {
		
		// Add new person to db
		personRepository.save(person);
		
		// Return home view
		return View.redirect(View.HOME_VIEW);
		
	}
	
	/**
	 * Delete person form.
	 *
	 * @param id the id
	 * @param model the model
	 * @return the string
	 */
	@GetMapping(Url.DELETE_PERSON_URL + "/{id}")
	public String deletePersonForm(@PathVariable("id") Long id, ModelMap model) {

		// Delete the person
		personRepository.deleteById(id);
		
		// Return home view
		return View.redirect(View.HOME_VIEW);

	}
		
}

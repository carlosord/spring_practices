package com.practices.demo.presentation;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.practices.demo.dto.PersonDto;
import com.practices.demo.presentation.form.PersonForm;
import com.practices.demo.presentation.front.Url;
import com.practices.demo.presentation.front.View;
import com.practices.demo.presentation.validation.PersonValidator;
import com.practices.demo.service.PersonService;
import com.practices.demo.service.exception.BusinessException;

/**
 * The Class PersonController.
 */
@Controller
public class PersonController {
		
	/** The person repository. */
	@Autowired
	private PersonService personService;
	
	/** The person validator. */
	@Autowired
	private PersonValidator personValidator;
	
	/**
	 * Show all.
	 *
	 * @param model the model
	 * @return the string
	 */
	@GetMapping(Url.HOME_URL)
	public String showAll(ModelMap model) {
		
		// Add all people to model
		model.addAttribute("people", personService.findAll());
		
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
		model.addAttribute("personForm", new PersonForm());
		
		// Return new person view
		return View.NEW_PERSON_VIEW;
		
	}

	/**
	 * Adds the new person.
	 *
	 * @param model the model
	 * @param personForm the person form
	 * @param bindingResult the binding result
	 * @return the string
	 */
	@PostMapping(Url.NEW_PERSON_URL)
	public String addNewPerson(ModelMap model, @Valid PersonForm personForm, BindingResult bindingResult) {
		
		// Validate person form
		personValidator.validate(personForm, bindingResult);
		
		if(bindingResult.hasErrors()) {						
			return View.NEW_PERSON_VIEW;
		}
		
		try {
			
			// Add new person to db
			personService.addNewPerson(personForm.toPerson());
			
			// Return new person view
			return View.redirect(View.HOME_VIEW);
			
		} catch (BusinessException b) {
			
			bindingResult.rejectValue(b.getField(), b.getMessage());
			
			// Go back form
			return View.NEW_PERSON_VIEW;
		}
		
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
		PersonDto person = personService.findPersonById(id);
		
		// Put data from dto to form
		PersonForm personForm = new PersonForm();
		personForm.getPersonForm(person);
		
		// Add new person to model
		model.addAttribute("personForm", personForm);
		
		// Return new person view
		return View.EDIT_PERSON_VIEW;
		
	}

	/**
	 * Update person.
	 *
	 * @param model the model
	 * @param personForm the person form
	 * @param bindingResult the binding result
	 * @return the string
	 */
	@PostMapping(Url.EDIT_PERSON_URL)
	public String updatePerson(ModelMap model, @Valid PersonForm personForm, BindingResult bindingResult) {

		// Validate person form
		personValidator.validate(personForm, bindingResult);
		
		if(bindingResult.hasErrors()) {						
			return View.NEW_PERSON_VIEW;
		}

		// Add new person to db
		personService.updatePerson(personForm.toPerson());
		
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
		personService.deletePersonForm(id);
		
		// Return home view
		return View.redirect(View.HOME_VIEW);

	}
		
}

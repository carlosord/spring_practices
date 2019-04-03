package com.practices.demo.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

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

}

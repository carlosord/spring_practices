package com.practices.demo.presentation;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.practices.demo.validations.ValidarFecha;
import com.practices.demo.validations.ValidateDni;
import com.practices.demo.validations.forms.PersonForm;
import com.practices.demo.bussines.PersonServiceIpl;
import com.practices.demo.dto.PersonaDTO;

@Controller
public class SimpleController {

	@Autowired
	private PersonServiceIpl serv;

	@Autowired
	ValidateDni validator;

	@Autowired
	ValidarFecha validatordate;


	@GetMapping("/home")
	public String homePage(Model model) {

		model.addAttribute("personas", serv.findAll());
		return "home";
	}

	@GetMapping("/register")
	public String registerPage(Model model) {

		model.addAttribute("personForm", new PersonForm());
		return "register";
	}

	@PostMapping("/create")
	public String registerUser(@Valid PersonForm personForm, BindingResult bindingResult, Model model)
			throws Exception {
		/**
		 * personForm lo transformas en un PersonDTO PersonDTO es el que pasas al
		 * servicio
		 */

		validator.validate(personForm, bindingResult);
		validatordate.validate(personForm, bindingResult);


		if (bindingResult.hasErrors()) {
			// model.addAttribute("persona", createperson);
			return "register";
		}

		try {
			serv.registerUser(personForm.toPerson());
			return "redirect:/home";

		} catch (Exception e) {
			bindingResult.rejectValue("dni", "error.dni.duplicated");
			// model.addAttribute("persona", createperson);
			return "register";
		}



	}

	@GetMapping("/edit/{id}")
	public String edituser(@PathVariable("id") String id, Model model) {

		PersonaDTO p = serv.edituser(id);

		PersonForm personForm = new PersonForm();
		personForm.getPersonForm(p);

		model.addAttribute("personForm", personForm);
		return "/update";

	}

	@PostMapping("/update")
	public String updatePerson(@Valid PersonForm personForm, BindingResult bindingResult, Model model) {

		validator.validate(personForm, bindingResult);
		validatordate.validate(personForm, bindingResult);

		if (bindingResult.hasErrors()) {
			// model.addAttribute("persona", createperson);
			return "update";
		}
		serv.updatePerson(personForm.toPerson());

		return "redirect:/home";
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteUser(@PathVariable long id, Model model) {

		serv.deleteUser(id);
		return "redirect:/home";
	}

}

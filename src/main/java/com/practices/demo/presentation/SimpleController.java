package com.practices.demo.presentation;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.practices.demo.business.PersonServices;
import com.practices.demo.dto.PersonDto;
import com.practices.demo.presentation.form.PersonForm;
import com.practices.demo.validations.ValidacionDate;
import com.practices.demo.validations.ValidacionDni;

@Controller
public class SimpleController {

	@Autowired
	private PersonServices serv;

	@Autowired
	private ValidacionDni validator;

	@Autowired
	private ValidacionDate validaFecha;

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
	public String submit(@Valid PersonForm personForm, BindingResult bindingResult, ModelMap model) {

		validator.validate(personForm, bindingResult);
		validaFecha.validate(personForm, bindingResult);

		if (bindingResult.hasErrors()) {
			return "register";
		}

		try {
			serv.create(personForm.toPerson());
			return "redirect:/home";

		} catch (Exception e) {
			bindingResult.rejectValue("dni", "error.dni.duplicated");
			return "register";
		}
	}

	@GetMapping("/edit/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model model) {

		PersonDto p = serv.findById(id);

		PersonForm personForm = new PersonForm();
		personForm.getPersonForm(p);
		model.addAttribute("personForm", personForm);
		return "/update";
	}

	@PostMapping("/update")
	public String updatePerson(@Valid PersonForm personForm, Model model, BindingResult bindingResult) {
		validator.validate(personForm, bindingResult);
		validaFecha.validate(personForm, bindingResult);

		if(bindingResult.hasErrors()) {
			return "update";
		}

		serv.updatePerson(personForm.toPerson());
		return "redirect:/home";
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable long id, ModelMap model) {
		serv.delete(id);
		return "redirect:/home";
	}

}

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

import com.practices.demo.model.Persona;
import com.practices.demo.bussines.PersonServiceIpl;

@Controller
public class SimpleController {

	@Autowired
	private PersonServiceIpl serv;

	@GetMapping("/home")
	public String homePage(Model model) {

		model.addAttribute("personas", serv.findAll());
		return "home";
	}

	@GetMapping("/register")
	public String registerPage(Model model) {

		model.addAttribute("persona", new Persona());
		return "register";
	}

	@PostMapping("/create")
	public String registerUser(@Valid Persona createperson, BindingResult bindingResult, Model model) {


		if (bindingResult.hasErrors()) {
			return "register";
		}

		serv.registerUser(createperson, bindingResult);

		return "redirect:/home";

	}

	@GetMapping("/edit/{id}")
	public String edituser(@PathVariable("id") String id, Model model) {

		Persona p = serv.edituser(id);
		model.addAttribute("persona", p);
		return "/update";

	}

	@PostMapping("/update")
	public String updatePerson(Persona updateperson, Model model) {

		serv.updatePerson(updateperson);
		return "redirect:/home";
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteUser(@PathVariable long id, Model model) {

		serv.deleteUser(id);
		return "redirect:/home";
	}

}

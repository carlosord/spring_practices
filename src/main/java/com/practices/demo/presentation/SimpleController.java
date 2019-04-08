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
import com.practices.demo.model.Persona;



@Controller
public class SimpleController{

	@Autowired
	private PersonServices serv;

    @GetMapping("/home")
    public String homePage(Model model) {
    model.addAttribute("personas",serv.findAll());
        return "home";
    }

    @GetMapping("/register")
    public String registerPage(Model model) {
    	model.addAttribute("persona", new Persona());
        return "register";
    }

    @PostMapping("/create")
    public String submit(@Valid Persona createPerson, BindingResult bindingResult,  ModelMap model) {

    	if (bindingResult.hasErrors()) {
			return "register";
		}

    	 serv.create(createPerson, bindingResult);

    	 return "redirect:/home";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {

    	Persona p = serv.findById(id);
    	model.addAttribute("persona", p);
    	return "/update";
    }

    @PostMapping("/update")
    public String updatePerson(Persona updatePerson, Model model) {
    	serv.updatePerson(updatePerson);
    	return "redirect:/home";
    }


    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable long id, ModelMap model) {
    	serv.delete(id);
    	return "redirect:/home";
    }

}


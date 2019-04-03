package com.practices.demo.presentation;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.practices.demo.model.Persona;
import com.practices.demo.persistence.PersonaRepository;


@Controller
public class SimpleController{
	
	@Autowired
	private PersonaRepository repo;
 
    @GetMapping("/home")
    public String homePage(Model model) {
        model.addAttribute("personas", repo.findAll());
        return "home";
    }
    
    @GetMapping("/register")
    public String registerPage(Model model) {
    	model.addAttribute("create", new Persona());
        return "register";
    }
    
    @PostMapping("/create")
    public String submit(Persona createPerson,  ModelMap model) {
    	
    	
    	System.err.println("person:" + createPerson);
    	
    	repo.save(createPerson);
    	//model.addAttribute("personas",repo.findAll());
        return "redirect:/home";
    }
    
    @PostMapping("/delete")
    public String delete(Persona deletePerson, ModelMap model) {
    	
    	repo.delete(deletePerson);
    	
    	return "home";
    }
}
    

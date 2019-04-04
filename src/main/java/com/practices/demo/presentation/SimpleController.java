package com.practices.demo.presentation;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	public String registerUser( Persona createperson, Model model) {
		
		
		System.err.println("Person:" + createperson);
		
		repo.save(createperson);
//		model.addAttribute("personas", repo.findAll());
		return "redirect:/home";
		
	}
	
	
	@GetMapping("/edit/{id}")     
	public String edituser(@PathVariable("id") String id, Model model) {  
		
		Persona p = repo.findById(Long.valueOf(id))      
				.orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));  
		
		model.addAttribute("persona", p);       
		return "/update";    
		
	}       
	
	@PostMapping("/update/{id}")  
    public String updatePerson(Persona updateperson, Model model) {
		
		
		
		repo.save(updateperson); 
	
		return "redirect:/home";     }
	
	
	
	@RequestMapping(value= "/delete/{id}", method=RequestMethod.GET)
	public String deleteUser(@PathVariable long id, Model model) {
		
		
		repo.deleteById(id);

		return"redirect:/home";
		
	}
	

	
}

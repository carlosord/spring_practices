package com.practices.demo.presentation;

import java.awt.print.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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
	

	
}

package com.practices.demo.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
}

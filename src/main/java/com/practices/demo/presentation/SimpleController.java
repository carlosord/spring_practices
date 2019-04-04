package com.practices.demo.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
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
    public String submit(Persona createPerson,  ModelMap model) {
    	
    	
    	System.err.println("person:" + createPerson);
    	
    	repo.save(createPerson);
    	//model.addAttribute("personas",repo.findAll());
        return "redirect:/home";
    }
    
    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Persona p = repo.findById(id)
          .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
         
        model.addAttribute("persona", p);
        return "/update";
    }
    
    @PostMapping("/update/{id}")
    public String updatePerson(Persona updatePerson, Model model) {
             
        repo.save(updatePerson);
        return "redirect:/home";
    }
         
    
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable long id, ModelMap model) {   
    	repo.deleteById(id);
    	
    	return "redirect:/home";
    }
}
    

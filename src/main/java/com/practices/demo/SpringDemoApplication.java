package com.practices.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.practices.demo.persistence.PersonaRepository;

@SpringBootApplication
public class SpringDemoApplication {
	
	@Autowired
	private static PersonaRepository repositorio;

	public static void main(String[] args) {
		SpringApplication.run(SpringDemoApplication.class, args);
		
		repositorio.findAll().forEach((p)->System.out.println(p.getName()));
		
	}
	
	
}

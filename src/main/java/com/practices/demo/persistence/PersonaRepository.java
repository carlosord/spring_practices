package com.practices.demo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practices.demo.model.Persona;

@Repository
public interface PersonaRepository extends JpaRepository <Persona, Long> {

	
	
}
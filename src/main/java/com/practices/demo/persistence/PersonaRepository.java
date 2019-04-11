package com.practices.demo.persistence;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practices.demo.model.Persona;
import com.practices.demo.utils.PersonUtils;

@Repository
public interface PersonaRepository  extends JpaRepository<Persona, Long>{
	//Consulta para buscar por dni
	Persona findByDni(String dni);


}

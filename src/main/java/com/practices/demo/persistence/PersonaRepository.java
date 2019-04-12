package com.practices.demo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practices.demo.model.Persona;

/**
 * Esta clase de tipo interface ses el repositorio donde se pueden realizar consultas
 * @author Jairo.Rodriguez
 *
 */

@Repository
public interface PersonaRepository extends JpaRepository <Persona, Long> {

	Persona findByDni(String dni);

}

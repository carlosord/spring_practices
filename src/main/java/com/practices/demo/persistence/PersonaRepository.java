package com.practices.demo.persistence;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practices.demo.model.Persona;
import com.practices.demo.utils.PersonUtils;

/**
 * Esta clase de tipo interface es el repositorio donde se puede realizar consultas.
 * @author Daniel.perez
 *
 */

@Repository
public interface PersonaRepository  extends JpaRepository<Persona, Long>{
	/**
	 * Esta "consulta" sirve para buscar a la {@code Persona} por DNI.
	 * @param dni variable que se le pasa de tipo cadena.
	 */
	Persona findByDni(String dni);


}

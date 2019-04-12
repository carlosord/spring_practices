package com.practices.demo.bussines;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

import com.practices.demo.dto.PersonaDTO;
import com.practices.demo.model.Persona;
import com.practices.demo.persistence.PersonaRepository;
import com.practices.demo.utils.PersonUtils;

/**
 * Esta clase es la encargada de enviar las operaciones logicas a la clase
 * SimpleController
 *
 * @author Jairo.Rodriguez
 *
 */

@Component
public class PersonServiceIpl implements PersonService {

	/**
	 * Es la variable que llama al repositorio PersonaRepository
	 */

	@Autowired
	private PersonaRepository repo;



	/**
	 * Este metodo se encarga de mostrar el listado en la tabla buscandolos en la base de datos a traves del repositorio y mostrandolos
	 *
	 * @return retorna el listado
	 *
	 */
	public List<PersonaDTO> findAll() {

		List<PersonaDTO> listdto = new ArrayList<PersonaDTO>();

		List<Persona> personlist = repo.findAll();

		for (int i = 0; i < personlist.size(); i++) {

			listdto.add(PersonUtils._toConvertPersonEntity(personlist.get(i)));

		}

		return listdto;

	}


	/**
	 * Este metodo se encarga de registrar los usuarios. Comprueba que el dni no esta duplicado (y si lo esta saca una excepcion), y
	 * tras esta comprobacion convierte la persona de tipo dto a un tipo persona para guardarlo en el repositorio.
	 *
	 *@param createperson
	 *			variable creada para llamar a la clase PersonDTO
	 *
	 * @return retorna un tipo PersonaDTO
	 */
	public PersonaDTO registerUser(PersonaDTO createperson) throws Exception {

		if (repo.findByDni(createperson.getDni()) != null)
			throw new Exception("error.dni.duplicated");

		Persona p = repo.save(PersonUtils._toConvertPersonDTO(createperson));

		return PersonUtils._toConvertPersonEntity(p);

	}


	/**
	 * Este metodo se encarga de buscar los usuarios por el id
	 *
	 *@param id
	 *			variable creada para buscar por id al usuario
	 *
	 * @return retorna la id del usuario y si no puede retornarla salta una excepcion
	 */
	public PersonaDTO edituser(String id) {

		Persona p = repo.findById(Long.valueOf(id))
				.orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));

		return PersonUtils._toConvertPersonEntity(p);

	}


	/**
	 * Este metodo sirve para modificar el usuario y guardar los cambios en el repositorio
	 *
	 *@param updateperson
	 *			variable creada para llamar a la clase PersonaDTO
	 *
	 * @return retorna un tipo persona dto
	 */
	public PersonaDTO updatePerson(PersonaDTO updateperson) {

		Persona p = repo.save(PersonUtils._toConvertPersonDTO(updateperson));

		return PersonUtils._toConvertPersonEntity(p);

	}


	/**
	 * Este metodo sirve para eliminar un usuario buscandolo por su id
	 */
	public void deleteUser(long id) {

		repo.deleteById(id);

	}

}
